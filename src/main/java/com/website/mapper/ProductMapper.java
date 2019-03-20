package com.website.mapper;

import com.website.entity.Product;

import java.util.List;

public interface ProductMapper {

    public Product getOneById(Integer id);

    public List<Product> getAll(Product product);

    public void insert(Product product);

    public void update(Product product);

    public void delete(Integer id);

}
