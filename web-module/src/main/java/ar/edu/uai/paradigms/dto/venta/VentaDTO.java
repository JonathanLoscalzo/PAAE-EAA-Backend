package ar.edu.uai.paradigms.dto.venta;

import ar.edu.uai.paradigms.dto.DTO;
import ar.edu.uai.paradigms.dto.cliente.ClienteDTO;

import java.util.Collection;
import java.util.Date;

/**
 * Created by jloscalzo on 26/05/16.
 */
public class VentaDTO extends DTO<Integer> {
    @Override
    protected Integer getId() {
        return null;
    }

    public Integer id;

    public Date fecha;

    public int nro;

    public ClienteDTO cliente;

    public Collection<VentaDetalleDTO> detalles;

    public Collection<FormaPagoDTO> formasPago;
}
