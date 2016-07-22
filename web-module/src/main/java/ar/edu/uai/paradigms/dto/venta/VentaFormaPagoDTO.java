package ar.edu.uai.paradigms.dto.venta;

import ar.edu.uai.model.formaPago.FormaPago;
import ar.edu.uai.model.venta.Venta;
import ar.edu.uai.model.venta.VentaFormaPago;
import ar.edu.uai.paradigms.dto.DTO;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

/**
 * Created by jloscalzo on 12/06/16.
 */
public class VentaFormaPagoDTO implements DTO<Integer> {

    private Double cantidad;

    private FormaPagoDTO formaPago;

    private VentaDTO venta;

    private Integer id;

    @JsonCreator
    public VentaFormaPagoDTO(@JsonProperty("cantidad") Double cantidad,
                             @JsonProperty("formaPago") FormaPagoDTO formaPago,
                             @JsonProperty VentaDTO venta,
                             @JsonProperty Integer id) {
        this.cantidad = cantidad;
        this.formaPago = formaPago; //una forma de pago con ID solamente
        this.venta = venta;
        this.id = id;
    }

    @JsonCreator
    public VentaFormaPagoDTO(@JsonProperty("cantidad") Double cantidad,
                             @JsonProperty("formaPago") FormaPagoDTO formaPago,
                             @JsonProperty VentaDTO venta) {
        this.cantidad = cantidad;
        this.formaPago = formaPago; //una forma de pago con ID solamente
        this.venta = venta;
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
