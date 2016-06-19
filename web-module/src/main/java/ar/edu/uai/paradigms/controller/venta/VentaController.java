package ar.edu.uai.paradigms.controller.venta;

import ar.edu.uai.model.Generics.Model;
import ar.edu.uai.paradigms.controller.Generics.BaseController;
import ar.edu.uai.paradigms.dto.DTO;
import ar.edu.uai.paradigms.dto.venta.VentaDTO;
import ar.edu.uai.paradigms.dto.venta.criterias.VentaCriteriaDTO;
import ar.edu.uai.paradigms.service.FormaPagoService;
import ar.edu.uai.paradigms.service.Service;
import ar.edu.uai.paradigms.service.VentaDetalleService;
import ar.edu.uai.paradigms.translator.Generics.Translator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jloscalzo on 26/05/16.
 */

@Controller
@RequestMapping("/Venta")
public class VentaController extends BaseController<VentaDTO, VentaCriteriaDTO> {
    private VentaDetalleService ventaDetalleService;
    private FormaPagoService formaPagoService;

    public VentaController(Service service, Translator<DTO, Model> translator) {
        super(service, translator);
    }

    public void setFormaPagoService(FormaPagoService formaPagoService) {
        this.formaPagoService = formaPagoService;
    }

    public void setVentaDetalleService(VentaDetalleService ventaDetalleService) {
        this.ventaDetalleService = ventaDetalleService;
    }

    /*
    * Que debería tener este controller
    * GenerarFactura ( VentaDTO ) a partir de una venta genera una factura
    * FacturaVacia ( cliente, vendedor) crea una factura vacía y la retorna con las formas de pago correspondientes
    * EliminarFactura (id)
    *
    * */
}
