package ar.edu.uai.paradigms.dto.proveedor;

import ar.edu.uai.paradigms.dto.DTO;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Skeith on 19/05/2016.
 */
public class ProveedorDTO extends DTO<Integer> {
    private Integer id;

    private String name;
    private String product_request_url;

    @JsonCreator
    public ProveedorDTO(@JsonProperty("id") Integer id,
                       @JsonProperty("name") String name,
                       @JsonProperty("product_request_url") String product_request_url)
    {
        this.id = id;
        this.name = name;
        this.product_request_url = product_request_url;

    }

    @Override
    public Integer getId()
    {
        return id;
    }


    @Override
    public String toString()
    {
        return this.getClass().getSimpleName() + " [id=" + id + ", nombre=" + name + "]";
    }


    public String getName()
    {
        return name;
    }

    public String getProduct_request_url()
    {
        return product_request_url;
    }
}