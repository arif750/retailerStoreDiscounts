package org.store.service.item;

import org.store.domain.Item;

import java.util.List;

public interface ItemService {
    public List<Item> getAllItems();
    public Item getItemByItemId(int itemId);
    public Item addItem(Item item);
}
