package ar.edu.uai.paradigms.service.impl;

import ar.edu.uai.model.venta.Venta;
import ar.edu.uai.model.venta.VentaFormaPago;
import ar.edu.uai.model.ventaDetalle.VentaDetalle;
import ar.edu.uai.paradigms.dao.Generics.PersistentDAO;
import ar.edu.uai.paradigms.service.*;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jloscalzo on 25/05/16.
 */
public class VentaServiceImpl extends ServiceImpl<Venta,Integer> implements VentaService {

    private FormaPagoService formaPagoService;
    private ProductoService productoService;
    private ClienteService clienteService;

    public VentaServiceImpl(PersistentDAO dao){
        super(dao);
    }

    @Override
    public Venta save(Venta venta) {
        // debo validar si hay stock de todos los productos
        venta.getVentaFormasPago().stream().forEach(d -> {
            if ( formaPagoService.exist(d.getFormaPago().getId()))
            d.setFormaPago(formaPagoService.retrieve(d.getFormaPago().getId()));
        });

        venta.getDetalles().stream().forEach(d ->{
            if ( productoService.exist(d.getProducto().getId())) {
                d.setProducto(productoService.retrieve(d.getProducto().getId()));
            }
        });

        if (clienteService.exist(venta.getCliente().getId())) {
            venta.setCliente(clienteService.retrieve(venta.getCliente().getId()));
        }

        return super.save(venta);
    }

    @Override
    public Boolean validateModel(Venta v) {
        Boolean valid = false;

        List<VentaDetalle> hasNoStock = v.getDetalles()
                .stream()
                .filter(d -> productoService.exist(d.getProducto().getId()) && !productoService.hasStock(d.getProducto().getId(), d.getCantidad()))
                .collect(Collectors.toList());
        if (hasNoStock.size() > 0 ){
            hasNoStock.forEach(d -> v.addMessage("No tiene stock "+d.getProducto().getNombre()+" stock: "+d.getProducto().getCurrentUnits()));
        }

        v.getDetalles().forEach(d -> productoService.discount(d.getProducto().getId(), d.getCantidad()));

        try {
            List<VentaFormaPago> hasNoFounds = v.getVentaFormasPago()
                    .stream()
                    .filter(d -> !formaPagoService.couldDiscount(d.getFormaPago().getId(), d.getCantidad()))
                    .collect(Collectors.toList());
            if (hasNoFounds.size() > 0 ){
                //TODO AGREGARLE ERRORES AL OBJETO DE VENTA
                hasNoFounds.forEach(d -> v.addMessage("No tiene fondos "+d.getFormaPago().getNombre()));
                throw new ValidationException("Sin Fondos");
            }
        } catch (ValidationException ve) {
            // agregar los productos de nuevo
            v.getDetalles().forEach(d -> productoService.restore(d.getProducto().getId(), d.getCantidad()));
        }

        v.getVentaFormasPago().stream().forEach(x -> formaPagoService.discount(x.getFormaPago().getId(), x.getCantidad()));
        return v.hasError();
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
}
