package ar.edu.uai.paradigms.controller.item;

import ar.edu.uai.model.item.Item;
import ar.edu.uai.model.item.ItemCriteria;
import ar.edu.uai.paradigms.dto.item.ItemCriteriaDTO;
import ar.edu.uai.paradigms.dto.item.ItemDTO;
import ar.edu.uai.paradigms.service.ItemService;
import ar.edu.uai.paradigms.translator.item.ItemTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Hal on 18/04/2016.
 */
@Controller
@RequestMapping("/items")
public class ItemController {
    public ItemController(
            ItemService itemService,
            ItemTranslator itemTranslator) {
        super();
        this.itemService = itemService;
        this.itemTranslator = itemTranslator;
    }

    private static final Logger LOGGER = LoggerFactory
            .getLogger(ItemController.class);

    private ItemService itemService;

    private ItemTranslator itemTranslator;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public
    @ResponseBody
    ResponseEntity<ItemDTO> create(@RequestBody ItemDTO itemDTO) {
        LOGGER.debug("Received DTO: " + itemDTO);
        Item itemModel = this.itemTranslator.translate(itemDTO);
        Item item = this.itemService.saveItem(itemModel);
        ItemDTO itemDTOOutput = this.itemTranslator.translateToDTO(item);
        return new ResponseEntity<ItemDTO>(itemDTOOutput, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<List<ItemDTO>> retrieveByCriteria(ItemCriteriaDTO itemCriteria) {
        LOGGER.debug("Received QUERY: " + itemCriteria);
        ItemCriteria criteria = this.itemTranslator.translateCriteria(itemCriteria);
        List<Item> items = this.itemService.retrieveByCriteria(criteria);
        List<ItemDTO> itemsDTOs = this.itemTranslator.translateToDTO(items);
        return new ResponseEntity<List<ItemDTO>>(itemsDTOs, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{identifier}")
    public
    @ResponseBody
    ResponseEntity<ItemDTO> getItem(@PathVariable Integer identifier) throws InterruptedException {
        Item retrievedItem = this.itemService.retrieveItem(identifier);
        ItemDTO item = this.itemTranslator.translateToDTO(retrievedItem);
        if (item != null) {
            return new ResponseEntity<ItemDTO>(item, HttpStatus.OK);
        }
        return new ResponseEntity<ItemDTO>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{identifier}")
    public
    @ResponseBody
    ResponseEntity<String> delete(@PathVariable Integer identifier) {
        this.itemService.deleteItem(identifier);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }
}
