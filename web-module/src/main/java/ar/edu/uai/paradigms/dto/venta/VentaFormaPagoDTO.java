package ar.edu.uai.paradigms.dto.venta;

import ar.edu.uai.paradigms.dto.DTO;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jloscalzo on 12/06/16.
 */
public class VentaFormaPagoDTO implements DTO<Integer> {

    private Double cantidad;

    @JsonProperty("payment_form")
    private FormaPagoDTO formaPago;

    @JsonIgnore
    private VentaDTO venta;

    private Integer id;

    @JsonCreator
    public VentaFormaPagoDTO(@JsonProperty("cantidad") Double cantidad,
                             @JsonProperty("payment_form_id") Integer formaPagoId,
                             @JsonProperty("sale_id") Integer saleId,
                             @JsonProperty("id") Integer id) {
        this.cantidad = cantidad;
        this.formaPago = new FormaPagoDTO(formaPagoId, null, null); //una forma de pago con ID solamente
        this.venta = new VentaDTO(saleId, null, null, Math.toIntExact(0), null, null, null);
        this.id = id;
    }

    public VentaFormaPagoDTO(Double cantidad, FormaPagoDTO formaPagoDTO, Integer id) {
        this.cantidad = cantidad;
        this.formaPago = formaPagoDTO;//una forma de pago con ID solamente
        this.id = id;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public FormaPagoDTO getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPagoDTO formaPago) {
        this.formaPago = formaPago;
    }

    public VentaDTO getVenta() {
        return venta;
    }

    public void setVenta(VentaDTO venta) {
        this.venta = venta;
    }
}
