package ar.edu.uai.paradigms.service.impl;

import ar.edu.uai.model.venta.Venta;
import ar.edu.uai.model.venta.VentaFormaPago;
import ar.edu.uai.model.ventaDetalle.VentaDetalle;
import ar.edu.uai.paradigms.dao.Generics.PersistentDAO;
import ar.edu.uai.paradigms.service.FormaPagoService;
import ar.edu.uai.paradigms.service.ProductoService;
import ar.edu.uai.paradigms.service.VentaDetalleService;
import ar.edu.uai.paradigms.service.VentaService;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jloscalzo on 25/05/16.
 */
public class VentaServiceImpl extends ServiceImpl<Venta,Integer> implements VentaService {

    private FormaPagoService formaPagoService;
    private ProductoService productoService;

    public VentaServiceImpl(PersistentDAO dao){
        super(dao);
    }

    @Override
    public Venta save(Venta venta) {
        // debo validar si hay stock de todos los productos


        return super.save(venta);
    }

    @Override
    public Boolean validateModel(Venta v) {


        List<VentaDetalle> hasNoStock = v.getDetalles()
                .stream()
                .filter(d -> productoService.exist(d.getProducto().getId()) && !productoService.hasStock(d.getProducto().getId(), d.getCantidad()))
                .collect(Collectors.toList());
        if (hasNoStock.size() > 0 ){
            //todo AGREGARLE ERRORES AL OBJETO VENTA
        }

        v.getDetalles().forEach(d -> productoService.discount(d.getProducto().getId(), d.getCantidad()));

        try {
            List<VentaFormaPago> hasNoFounds = v.getVentaFormasPago()
                    .stream()
                    .filter(d -> !formaPagoService.couldDiscount(d.getFormaPago().getId(), d.getCantidad()))
                    .collect(Collectors.toList());
            if (hasNoFounds.size() > 0 ){
                //TODO AGREGARLE ERRORES AL OBJETO DE VENTA
                throw new ValidationException("Hay formas de pagos sin fondos");
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
}
