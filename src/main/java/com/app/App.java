package com.app;

import com.app.model.Item;
import com.app.service.ItemService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "file:src/main/resources/context.xml"
        );

        ItemService itemService = applicationContext.getBean("itemService", ItemService.class);

        List<Item> items = itemService.findAll();

        System.out.println(items);
    }
}
