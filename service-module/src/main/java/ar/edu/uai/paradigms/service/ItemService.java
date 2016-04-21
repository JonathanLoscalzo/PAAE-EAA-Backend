package ar.edu.uai.paradigms.service;


import ar.edu.uai.model.item.Item;
import ar.edu.uai.model.item.ItemCriteria;

import java.util.List;

/**
 * Created by Skeith on 17/04/2016.
 */
public interface ItemService extends Service<Item,Integer>
{

    Item saveItem(Item item);

    Item retrieveItem(Integer identifier);

    void deleteItem(Integer identifier);

    List<Item> retrieveByCriteria(ItemCriteria criteria);
}
