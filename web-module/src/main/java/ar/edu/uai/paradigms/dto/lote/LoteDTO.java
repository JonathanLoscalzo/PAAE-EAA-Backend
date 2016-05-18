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
    private String      detail;
    private Date        expiration_date;
    private Date        entry_date;
    private Integer     product_id;

    private Integer     remaining_units;
    private Integer     total_units;


    @JsonCreator
    public LoteDTO(@JsonProperty("id")              Integer id,
                   @JsonProperty("expiration_date") Date expiration_date,
                   @JsonProperty("entry_date")      Date entry_date,
                   @JsonProperty("detail")          String detail,
                   @JsonProperty("product_id")      Integer product_id,
                   @JsonProperty("total_units")     Integer total_units)
    {
        this.id = id;
        this.detail = detail;
        this.expiration_date = expiration_date;
        this.entry_date = entry_date;
        this.product_id = product_id;
        this.remaining_units = total_units;
        this.total_units = total_units;
    }

    @Override
    public Integer getId() {
        return id;
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [id=" + id + ", detalle=" + detail + "]";
    }


    public void setRemaining_units(Integer remaining_units) {
        this.remaining_units = remaining_units;
    }

    public Integer getProduct_id() {
        return product_id;
    }
    public Integer getRemaining_units() {
        return remaining_units;
    }
    public Integer getTotal_units() {
        return total_units;
    }
    public Date getExpiration_date() {
        return expiration_date;
    }

    public String getDetail() {
        return detail;
    }

    public Date getEntry_date() {
        return entry_date;
    }

}
