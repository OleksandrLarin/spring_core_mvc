package com.app.controller;

import com.app.dto.ItemDto;
import com.app.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemsController {

    private final ItemService itemService;

    @GetMapping("items/{id}")
    public ItemDto getItem(@PathVariable int id) {
        return itemService.findById(id);
    }

    @GetMapping("items")
    public List<ItemDto> getAllItems() {
        return null;
    }

    @PostMapping("items")
    public ItemDto createItem(@RequestBody ItemDto itemDto) {
        return itemService.create(itemDto);
    }

    @PutMapping("items/{id}")
    public ItemDto updateItem(@RequestBody ItemDto itemDto, @PathVariable int id) {
        return null;
    }

    @DeleteMapping("items/{id}")
    public @ResponseBody
    ResponseEntity<String> delete(@PathVariable int id) {
        //Код для удаления Item
        return new ResponseEntity<String>("DELETE Response", HttpStatus.OK);
    }


}
