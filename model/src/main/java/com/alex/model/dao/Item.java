package com.alex.model.dao;

import org.springframework.data.annotation.Id;

public class Item {
    private final Long id;
    private final String name;
    private final Long price;
    private final String description;


    public Item(
            Long id,
            String name,
            Long price,
            String description

    ) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;

    }

    @Id
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }



    public com.alex.model.dao.Item updateWith(com.alex.model.dao.Item item) {
        return new com.alex.model.dao.Item(
                this.id,
                item.name,
                item.price,
                item.description

        );
    }
}
