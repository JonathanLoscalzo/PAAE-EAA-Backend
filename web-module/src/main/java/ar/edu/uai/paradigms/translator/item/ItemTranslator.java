package ar.edu.uai.paradigms.translator.item;

import ar.edu.uai.model.item.Item;
import ar.edu.uai.model.item.ItemCriteria;
import ar.edu.uai.paradigms.dto.item.ItemCriteriaDTO;
import ar.edu.uai.paradigms.dto.item.ItemDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hal on 18/04/2016.
 */
public class ItemTranslator {
    public Item translate(ItemDTO itemDTO) {
        return new Item(itemDTO.getId(), itemDTO.getName(), itemDTO.getPrice(), itemDTO.getAmount());
    }

    public ItemDTO translateToDTO(Item item) {
        if (item != null) {
            return new ItemDTO(item.getId(), item.getName(), item.getPrice(), item.getAmount());
        }
        return null;
    }

    public List<ItemDTO> translateToDTO(List<Item> items) {
        List<ItemDTO> itemResponse = new ArrayList<ItemDTO>();
        for(Item i : items) {
            ItemDTO itemDTO = this.translateToDTO(i);
            if(itemDTO != null) {
                itemResponse.add(itemDTO);
            }
        }
        return itemResponse;
    }

    public ItemCriteria translateCriteria(ItemCriteriaDTO itemCriteriaDTO) {
        return new ItemCriteria();
    }
}
