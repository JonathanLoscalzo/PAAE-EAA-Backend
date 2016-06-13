package ar.edu.uai.paradigms.controller.venta;

import ar.edu.uai.model.Generics.Model;
import ar.edu.uai.model.producto.Producto;
import ar.edu.uai.model.proveedor.Proveedor;
import ar.edu.uai.model.venta.Venta;
import ar.edu.uai.paradigms.controller.Generics.Controller;
import ar.edu.uai.paradigms.dto.DTO;
import ar.edu.uai.paradigms.dto.person.PersonDTO;
import ar.edu.uai.paradigms.dto.producto.ProductoDTO;
import ar.edu.uai.paradigms.dto.venta.VentaDTO;
import ar.edu.uai.paradigms.service.FormaPagoService;
import ar.edu.uai.paradigms.service.Service;
import ar.edu.uai.paradigms.service.VentaDetalleService;
import ar.edu.uai.paradigms.translator.Generics.Translator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.stream.Collectors;

/**
 * Created by jloscalzo on 26/05/16.
 */
@RequestMapping("/Venta")
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

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public
    @ResponseBody
    ResponseEntity<DTO> create(@RequestBody VentaDTO ventaDTO) {
        Venta ventaB = (Venta) this.translator.translate(ventaDTO);
        Venta ventaP = (Venta) this.service.save(ventaB);
        DTO ventaDTOOutput = (VentaDTO) this.translator.translateToDTO(ventaP);
        return new ResponseEntity<>(ventaDTOOutput, HttpStatus.CREATED);
    }




    /*
    * Que debería tener este controller
    * GenerarFactura ( VentaDTO ) a partir de una venta genera una factura
    * FacturaVacia ( cliente, vendedor) crea una factura vacía y la retorna con las formas de pago correspondientes
    * EliminarFactura (id)
    *
    * */
}
