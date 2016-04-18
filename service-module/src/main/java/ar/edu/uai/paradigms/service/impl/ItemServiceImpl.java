package ar.edu.uai.paradigms.service.impl;

import ar.edu.uai.model.item.Item;
import ar.edu.uai.model.item.ItemCriteria;
import ar.edu.uai.paradigms.dao.ItemDAO;
import ar.edu.uai.paradigms.service.ItemService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Skeith on 17/04/2016.
 */
public class ItemServiceImpl implements ItemService
{
    private ItemDAO itemDAO;

    public ItemServiceImpl(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    @Transactional
    public Item saveItem(Item item) {
        return this.itemDAO.create(item);
    }

    @Override
    public Item retrieveItem(Integer identifier) {
        return this.itemDAO.retrieve(identifier);
    }

    @Transactional
    @Override
    public void deleteItem(Integer identifier) {
        this.itemDAO.delete(identifier);
    }

    @Override
    public List<Item> retrieveByCriteria(ItemCriteria criteria) {
        return this.itemDAO.retrieveByCriteria(criteria);
    }
}
