package ar.edu.uai.paradigms.dto.venta;

import ar.edu.uai.paradigms.dto.DTO;
import ar.edu.uai.paradigms.dto.cliente.ClienteDTO;
import ar.edu.uai.paradigms.dto.usuario.UsuarioDTO;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;
import java.util.Date;

/**
 * Created by jloscalzo on 26/05/16.
 */
public class VentaDTO implements DTO<Integer> {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("fecha")
    private Date fecha;

    @JsonProperty("nro")
    private Integer nro;

    @JsonProperty("cliente")
    private ClienteDTO cliente;

    @JsonProperty("detalles")
    private Collection<VentaDetalleDTO> detalles;

    @JsonProperty("formasPago")
    private Collection<VentaFormaPagoDTO> formasPago;

    private UsuarioDTO usuario;

    @JsonCreator
    public VentaDTO(@JsonProperty("id") Integer id,
                    @JsonProperty("fecha") Date fecha,
                    @JsonProperty("nro") Integer nro,
                    @JsonProperty("client_id") Integer clienteId,
                    @JsonProperty("user_id") Integer userId,
                    @JsonProperty("sale_details") Collection<VentaDetalleDTO> detalles,
                    @JsonProperty("vfps") Collection<VentaFormaPagoDTO> formasPago) {

        this.id = id;
        this.fecha = fecha;
        this.nro = nro;
        this.cliente = new ClienteDTO(clienteId, null, "", "");
        this.detalles = detalles;
        this.formasPago = formasPago; //forma_pago_id y cantidad
        this.usuario = new UsuarioDTO(userId, null, null, null);
    }

    public VentaDTO(Integer id,
                    Date fecha,
                    Integer nro,
                    ClienteDTO cliente,
                    Collection<VentaDetalleDTO> detalles,
                    Collection<VentaFormaPagoDTO> formasPago,
                    UsuarioDTO usuarioDTO) {

        this.id = id;
        this.fecha = fecha;
        this.nro = nro;
        this.cliente = cliente;//solo ID
        this.detalles = detalles;
        this.formasPago = formasPago; //forma_pago_id y cantidad
        usuario = usuarioDTO;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getNro() {
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
