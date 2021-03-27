package com.app.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Item {
    private String name;
    private String description;
    private String status;
    private int priority;
    private LocalDate date;
}
