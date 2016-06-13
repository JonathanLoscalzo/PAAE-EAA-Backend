package ar.edu.uai.paradigms.dto.venta;

import ar.edu.uai.paradigms.dto.DTO;
import ar.edu.uai.paradigms.dto.cliente.ClienteDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;
import java.util.Date;

/**
 * Created by jloscalzo on 26/05/16.
 */
public class VentaDTO extends DTO<Integer> {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("fecha")
    private Date fecha;

    @JsonProperty("nro")
    private int nro;

    @JsonProperty("cliente")
    private ClienteDTO cliente;

    @JsonProperty("detalles")
    private Collection<VentaDetalleDTO> detalles;

    @JsonProperty("formasPago")
    private Collection<VentaFormaPagoDTO> formasPago;

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public Collection<VentaDetalleDTO> getDetalles() {
        return detalles;
    }

    public void setDetalles(Collection<VentaDetalleDTO> detalles) {
        this.detalles = detalles;
    }

    public Collection<VentaFormaPagoDTO> getFormasPago() {
        return formasPago;
    }

    public void setFormasPago(Collection<VentaFormaPagoDTO> formasPago) {
        this.formasPago = formasPago;
    }

    @Override
    public Integer getId() {
        return this.id;
    }
}
