package com.alex.model.dao;

import com.alex.model.dao.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InMemoryItemRepository extends CrudRepository<Item, Long> {}