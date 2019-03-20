package com.website.controller;

import com.website.DB.DBAcess;
import com.website.entity.Product;
import com.website.mapper.ProductMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProductControllerTest {

    @Test
    public void list() throws IOException {
        Product product=new Product();
        List<Product> list=new ArrayList<>();
        DBAcess dbAcess=new DBAcess();
        SqlSession sqlSession = dbAcess.getSqlSession();
        try {
            ProductMapper mapper =sqlSession.getMapper (ProductMapper.class);
            list =mapper.getAll(product);
            System.out.println(list.size());
            System.out.println(list);
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void getOne() throws IOException {
        Product product=new Product();
        DBAcess dbAcess=new DBAcess();
        SqlSession sqlSession = dbAcess.getSqlSession();
        try {
            ProductMapper mapper =sqlSession.getMapper (ProductMapper.class);
            product=mapper.getOneById(1);
            System.out.println("------------"+product.getId());
            System.out.println("------------"+product.getName());
            System.out.println("------------"+product.getType());
            System.out.println("------------"+product.getPrice());
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void delete() throws IOException {
        DBAcess dbAcess=new DBAcess();
        SqlSession sqlSession = dbAcess.getSqlSession();
        try {
            ProductMapper mapper =sqlSession.getMapper (ProductMapper.class);
            mapper.delete(2);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void insert() throws IOException {
        Product product=new Product();
        product.setId(3);
        product.setName("IMac");
        product.setType("电脑");
        product.setPrice(15000.0);

        DBAcess dbAcess=new DBAcess();
        SqlSession sqlSession = dbAcess.getSqlSession();
        try {
            ProductMapper mapper =sqlSession.getMapper (ProductMapper.class);
            mapper.insert(product);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }


    @Test
    public void update() throws IOException {
        Product product=new Product();
        product.setId(3);
        product.setName("IMac Pro");
        product.setType("台式电脑");
        product.setPrice(14500.0);

        DBAcess dbAcess=new DBAcess();
        SqlSession sqlSession = dbAcess.getSqlSession();
        try {
            ProductMapper mapper =sqlSession.getMapper (ProductMapper.class);
            mapper.update(product);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }



}