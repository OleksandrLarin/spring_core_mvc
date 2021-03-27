package com.app.service;

import com.app.dao.ItemDao;
import com.app.dto.ItemDto;
import com.app.model.Item;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    public static final String NEW = "new";
    private final ItemDao itemDao;

    @Override
    public List<Item> findAll() {
        return itemDao.findAll();
    }

    @Override
    public ItemDto findById(int id) {
        Item item = itemDao.findById(id);
        return ItemDto.builder()
                .name(item.getName())
                .description(item.getDescription())
                .build();
    }

    @Override
    public ItemDto create(ItemDto itemDto) {
        Item item = Item.builder()
                .name(itemDto.getName())
                .description(itemDto.getDescription())
                .status(NEW)
                .priority(2)
                .date(LocalDate.now())
                .build();

        itemDao.create(item);

        return itemDto;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Item item) {

    }
}
