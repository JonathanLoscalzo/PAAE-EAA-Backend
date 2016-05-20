package ar.edu.uai.paradigms.translator.proveedor;

import ar.edu.uai.model.proveedor.Proveedor;

import ar.edu.uai.model.proveedor.ProveedorCriteria;
import ar.edu.uai.paradigms.dto.proveedor.ProveedorCriteriaDTO;
import ar.edu.uai.paradigms.dto.proveedor.ProveedorDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Skeith on 19/05/2016.
 */
public class ProveedorTranslator
{
    public Proveedor translate(ProveedorDTO proveedorDTO)
    {
        return new Proveedor (proveedorDTO.getId(),
                proveedorDTO.getName(),
                proveedorDTO.getProduct_request_url());
    }

    public ProveedorDTO translateToDTO(Proveedor proveedor)
    {
        if (proveedor != null)
        {
            return new ProveedorDTO( proveedor.getId(),
                    proveedor.getNombre(),
                    proveedor.getPedidoURL());
        }
        return null;
    }

    public List<ProveedorDTO> translateToDTO(List<Proveedor> proovedores) {
        List<ProveedorDTO> proveedorResponse = new ArrayList<ProveedorDTO>();
        for(Proveedor i : proovedores) {
            ProveedorDTO proveedorDTO = this.translateToDTO(i);
            if(proveedorDTO != null) {
                proveedorResponse.add(proveedorDTO);
            }
        }
        return proveedorResponse;
    }

    public ProveedorCriteria translateCriteria(ProveedorCriteriaDTO proveedorCriteriaDTO) {
        return new ProveedorCriteria();
    }
}
