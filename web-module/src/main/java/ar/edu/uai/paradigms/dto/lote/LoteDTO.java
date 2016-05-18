package ar.edu.uai.paradigms.dto.lote;

import ar.edu.uai.model.producto.Producto;
import ar.edu.uai.paradigms.dto.DTO;



import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by Hal on 18/04/2016.
 */
public class LoteDTO extends DTO<Integer>
{

    private Integer     id;
    private String      detalle;
    private Date        fechaVencimiento;
    private Date        fechaEntrada;
    private Producto    producto;



    @JsonCreator
    public LoteDTO(@JsonProperty("id") Integer id,
                   @JsonProperty("expiration_date") Date fechaVencimiento,
                   @JsonProperty("entry_date")
                   @JsonFormat(
                           shape = JsonFormat.Shape.STRING,
                           pattern = "dd-MM-yyyy hh:mm:ss")
                   Date fechaEntrada,
                   @JsonProperty("detail") String detalle) {
        this.id = id;
        this.detalle = detalle;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaEntrada = fechaEntrada;

    }

    @Override
    public Integer getId() {
        return id;
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [id=" + id + ", detalle=" + detalle + "]";
    }


    public String getDetalle() {
        return detalle;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public Producto getProducto()
    {
        return producto;
    }

    public void setProducto(Producto producto)
    {
        this.producto = producto;
    }

}
