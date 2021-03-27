package com.app.service;

import com.app.dto.ItemDto;
import com.app.model.Item;

import java.util.List;

public interface ItemService {

    List<Item> findAll();

    ItemDto findById(int id);

    ItemDto create(ItemDto item);

    void delete(int id);

    void update(Item item);

}
