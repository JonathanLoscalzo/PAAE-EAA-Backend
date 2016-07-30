package ar.edu.uai.paradigms.controller.venta;

import ar.edu.uai.model.Generics.Model;
import ar.edu.uai.model.venta.Venta;
import ar.edu.uai.paradigms.controller.Generics.BaseController;
import ar.edu.uai.paradigms.dto.DTO;
import ar.edu.uai.paradigms.dto.venta.VentaDTO;
import ar.edu.uai.paradigms.dto.venta.criterias.VentaCriteriaDTO;
import ar.edu.uai.paradigms.service.FormaPagoService;
import ar.edu.uai.paradigms.service.Service;
import ar.edu.uai.paradigms.service.VentaDetalleService;
import ar.edu.uai.paradigms.service.VentaService;
import ar.edu.uai.paradigms.translator.Generics.Translator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    public
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/client/{client_id}")
    ResponseEntity<Collection<VentaDTO>> getClientSales(@PathVariable Integer client_id) throws InterruptedException {
        // comunicate con el servicio de clientes y pedile las ventas
        List<Venta> ventas = ((VentaService)this.service).GetClientSales(client_id);
        List<VentaDTO> ventasDTO = (List<VentaDTO>) translator.translateToDTO(ventas);
        return new ResponseEntity<>(ventasDTO, HttpStatus.OK);
    }
}
