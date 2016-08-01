package ar.edu.uai.paradigms.service.impl;

import ar.edu.uai.model.venta.Venta;
import ar.edu.uai.model.venta.VentaFormaPago;
import ar.edu.uai.model.ventaDetalle.VentaDetalle;
import ar.edu.uai.paradigms.dao.Generics.PersistentDAO;
import ar.edu.uai.paradigms.dao.VentaDAO;
import ar.edu.uai.paradigms.service.ClienteService;
import ar.edu.uai.paradigms.service.FormaPagoService;
import ar.edu.uai.paradigms.service.ProductoService;
import ar.edu.uai.paradigms.service.VentaService;

import javax.transaction.Transactional;
import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jloscalzo on 25/05/16.
 */
public class VentaServiceImpl extends ServiceImpl<Venta, Integer> implements VentaService {

    private FormaPagoService formaPagoService;
    private ProductoService productoService;
    private ClienteService clienteService;

    public VentaServiceImpl(PersistentDAO dao) {
        super(dao);
    }

    @Override
    @Transactional
    public Venta save(Venta venta) {
        // debo validar si hay stock de todos los productos
        venta.getVentaFormasPago().stream().forEach(d -> {
            if (formaPagoService.exist(d.getFormaPago().getId()))
                d.setFormaPago(formaPagoService.retrieve(d.getFormaPago().getId()));
        });

        venta.getDetalles().stream().forEach(d -> {
            if (productoService.exist(d.getProducto().getId())) {
                d.setProducto(productoService.retrieve(d.getProducto().getId()));
            }
        });

        if (clienteService.exist(venta.getCliente().getId())) {
            venta.setCliente(clienteService.retrieve(venta.getCliente().getId()));
        }

        return super.save(venta);
    }

    @Override
    @Transactional
    public Boolean validateModel(Venta v) {
        Boolean valid = false;
        List<VentaDetalle> hasNoStock = v.getDetalles()
                .stream()
                .filter(d -> productoService.exist(d.getProducto().getId()) && !productoService.hasStock(d.getProducto().getId(), d.getCantidad()))
                .collect(Collectors.toList());

        if (hasNoStock.size() > 0) {
            hasNoStock.forEach(d -> v.addMessage("El producto " + d.getProducto().getNombre() + "No tiene stock  stock: " + d.getProducto().getCurrentUnits()));
            return !v.hasError();
        }

        v.getDetalles().forEach(d -> {
            try {
                productoService.discount(d.getProducto().getId(), d.getCantidad());
            } catch (ValidationException e) {

            }
        });

        try {
            List<VentaFormaPago> hasNoFounds = v.getVentaFormasPago()
                    .stream()
                    .filter(d -> !formaPagoService.couldDiscount(d.getFormaPago().getId(), d.getCantidad()))
                    .collect(Collectors.toList());
            if (hasNoFounds.size() > 0) {
                hasNoFounds.forEach(d -> v.addMessage("La forma de pago  " + d.getFormaPago().getNombre() + "No tiene fondos"));
                throw new ValidationException("Sin Fondos");
            }
        } catch (ValidationException ve) {
            // agregar los productos de nuevo, como aún no hice update no pasa nada.
            v.getDetalles().forEach(d -> productoService.restore(d.getProducto().getId(), d.getCantidad()));
        }

        Double pagoTotal = v.getVentaFormasPago()
                .stream()
                .mapToDouble(VentaFormaPago::getCantidad)
                .sum();
        Double totalProd = v.getDetalles().stream().mapToDouble(a -> a.getCantidad() * a.getPrecio()).sum();

        if (pagoTotal < totalProd) {
            v.addMessage("No alcanza a cubrir el pago total");
            return false;
        }

        if (pagoTotal > totalProd && !v.getVentaFormasPago().stream().anyMatch(x -> x.getFormaPago().getPermiteDarCambio())) {
            v.addMessage("No puede ser mayor que el total, porque la forma de pago no permite dar cambio");
            return false;
        }

        v.getVentaFormasPago().stream().forEach(x -> formaPagoService.discount(x.getFormaPago().getId(), x.getCantidad()));
        return !v.hasError();
    }

    public void setFormaPagoService(FormaPagoService formaPagoService) {
        this.formaPagoService = formaPagoService;
    }

    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public void setProductoService(ProductoService productoService) {
        this.productoService = productoService;
    }

    @Override
    public List<Venta> GetClientSales(Integer client_id) {
        return ((VentaDAO) dao).getSalesFromClient(client_id);
    }
}
