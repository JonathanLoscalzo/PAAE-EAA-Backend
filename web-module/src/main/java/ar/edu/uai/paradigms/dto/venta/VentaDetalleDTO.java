package ar.edu.uai.paradigms.dto.venta;

import ar.edu.uai.paradigms.dto.DTO;
import ar.edu.uai.paradigms.dto.producto.ProductoDTO;

/**
 * Created by jloscalzo on 26/05/16.
 */
public class VentaDetalleDTO extends DTO<Integer> {
    @Override
    protected Integer getId() {
        return null;
    }

    private Integer id;

    private Integer fila;

    private ProductoDTO producto;

    private VentaDTO venta;

    private Integer cantidad;

    private Double precio;
}
