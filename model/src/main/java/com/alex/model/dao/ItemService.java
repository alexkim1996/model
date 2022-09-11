package com.alex.model.dao;

import org.springframework.data.map.repository.config.EnableMapRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.List;

@Service
@EnableMapRepositories

public class ItemService {

    private final CrudRepository<Item, Long> repository;

    public ItemService(CrudRepository<Item, Long> repository) {
        this.repository = repository;

        this.repository.saveAll(defaultItems());
    }

    private static List<Item> defaultItems() {
        return List.of(
                new Item(1L, "Cup", 599L, "Smooth"),
                new Item(2L, "Saucepan", 299L, "Hot"),
                new Item(3L, "Plate", 199L, "Flat")
        );
    }

    public List<Item> findAll() {
        List<Item> list = new ArrayList<>();
        Iterable<Item> items = repository.findAll();
        items.forEach(list::add);
        return list;
    }

    public Optional<Item> find(Long id) {
        return repository.findById(id);
    }

    public Item create(Item item) {

        Item copy = new Item(
                new Date().getTime(),
                item.getName(),
                item.getPrice(),
                item.getDescription()

        );
        return repository.save(copy);
    }

    public Optional<Item> update( Long id, Item newItem) {
        // Only update an item if it can be found first.
        return repository.findById(id)
                .map(oldItem -> {
                    Item updated = oldItem.updateWith(newItem);
                    return repository.save(updated);
                });
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

