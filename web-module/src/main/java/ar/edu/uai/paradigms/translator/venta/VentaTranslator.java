package ar.edu.uai.paradigms.translator.venta;

import ar.edu.uai.model.Generics.ModelCriteria;
import ar.edu.uai.model.venta.Venta;
import ar.edu.uai.paradigms.dto.CriteriaDTO;
import ar.edu.uai.paradigms.dto.venta.VentaDTO;
import ar.edu.uai.paradigms.translator.Generics.TranslatorImpl;
import ar.edu.uai.paradigms.translator.cliente.ClienteTranslator;
import ar.edu.uai.paradigms.translator.usuario.UsuarioTranslator;

/**
 * Created by jloscalzo on 26/05/16.
 */
public class VentaTranslator extends TranslatorImpl<VentaDTO, Venta> {

    private VentaFormaPagoTranslator ventaFormaPagoTranslator;
    private VentaDetalleTranslator ventaDetalleTranslator;
    private ClienteTranslator clienteTranslator;
    private UsuarioTranslator usuarioTranslator;

    @Override
    public Venta translate(VentaDTO dto) {
        Venta v = new Venta();
        v.setNro(dto.getNro());
        v.setFecha(dto.getFecha());
        v.setId(dto.getId());
        v.setCliente(clienteTranslator.translate(dto.getCliente()));
        v.setDetalles(ventaDetalleTranslator.translate(dto.getDetalles()));
        v.setVentaFormasPago(ventaFormaPagoTranslator.translate(dto.getFormasPago()));
        return v;
    }

    @Override
    public VentaDTO translateToDTO(Venta v) {
        return new VentaDTO(
                v.getId(),
                v.getFecha(),
                v.getNro(),
                clienteTranslator.translateToDTO(v.getCliente()),
                ventaDetalleTranslator.translateToDTO(v.getDetalles()),
                ventaFormaPagoTranslator.translateToDTO(v.getVentaFormasPago()),
                usuarioTranslator.translateToDTO(v.getUsuario()));
    }

    @Override
    public ModelCriteria translateCriteria(CriteriaDTO<VentaDTO> modelCriteria) {
        return null;
    }

    public void setVentaFormaPagoTranslator(VentaFormaPagoTranslator ventaFormaPagoTranslator) {
        this.ventaFormaPagoTranslator = ventaFormaPagoTranslator;
    }

    public void setVentaDetalleTranslator(VentaDetalleTranslator ventaDetalleTranslator) {
        this.ventaDetalleTranslator = ventaDetalleTranslator;
    }

    public void setClienteTranslator(ClienteTranslator clienteTranslator) {
        this.clienteTranslator = clienteTranslator;
    }

    public void setUsuarioTranslator(UsuarioTranslator usuarioTranslator) {
        this.usuarioTranslator = usuarioTranslator;
    }
}
