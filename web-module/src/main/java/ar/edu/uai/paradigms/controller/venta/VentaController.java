package ar.edu.uai.paradigms.controller.venta;

import ar.edu.uai.model.Generics.Model;
import ar.edu.uai.paradigms.controller.Generics.Controller;
import ar.edu.uai.paradigms.dto.DTO;
import ar.edu.uai.paradigms.service.FormaPagoService;
import ar.edu.uai.paradigms.service.Service;
import ar.edu.uai.paradigms.service.VentaDetalleService;
import ar.edu.uai.paradigms.translator.Generics.Translator;

/**
 * Created by jloscalzo on 26/05/16.
 */
public class VentaController extends Controller {
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
}
