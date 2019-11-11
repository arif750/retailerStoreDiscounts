package org.store.service.item;

import org.store.domain.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemServiceImpl implements ItemService {
    //map as database
    private static Map<Integer,Item> integerItemMap;
    {
        integerItemMap=new HashMap<>();
        Item item1=new Item();
        item1.setPrice(15);
        item1.setItemId(1);
        item1.setItemType("nogrocery");
        integerItemMap.put(1,item1);
        Item item2=new Item();
        item2.setPrice(10);
        item2.setItemId(2);
        item2.setItemType("nogrocery");
        integerItemMap.put(2,item2);
        Item item3=new Item();
        item3.setPrice(5);
        item3.setItemId(2);
        item3.setItemType("nogrocery");
        integerItemMap.put(3,item3);
        integerItemMap.put(2,item2);
        Item item4=new Item();
        item4.setPrice(5);
        item4.setItemId(4);
        item4.setItemType("grocery");
        integerItemMap.put(4,item4);
    }
    @Override
    public List<Item> getAllItems() {
        return (List<Item>)integerItemMap.values();
    }

    @Override
    public Item getItemByItemId(int itemId) {
        return integerItemMap.get(itemId);
    }

    @Override
    public Item addItem(Item item) {
        return integerItemMap.put(item.getItemId(), item);
    }
}
