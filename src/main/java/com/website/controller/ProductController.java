package com.website.controller;

import com.website.DB.DBAcess;
import com.website.entity.Product;
import com.website.mapper.ProductMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @ResponseBody
    @RequestMapping("/list")
    public List<Product> list(@RequestBody Product product) throws IOException {

        List<Product> list=new ArrayList<>();
        DBAcess dbAcess=new DBAcess();
        SqlSession sqlSession = dbAcess.getSqlSession();
        System.out.println("---------------"+product.getName());
        System.out.println("---------------"+product.getType());
        try {
            ProductMapper mapper =sqlSession.getMapper (ProductMapper.class);
            list =mapper.getAll(product);
            return list;
        }finally {
            sqlSession.close();
        }


    }


    @ResponseBody
    @RequestMapping("/getOne")
    public Product getOne(@RequestBody Integer id) throws IOException {
        Product product=new Product();
        DBAcess dbAcess=new DBAcess();
        SqlSession sqlSession = dbAcess.getSqlSession();
        try {
            ProductMapper mapper =sqlSession.getMapper (ProductMapper.class);
            product =mapper.getOneById(id);
            return product;
        }finally {
            sqlSession.close();
        }

    }


    @ResponseBody
    @RequestMapping("/delete")
    public void delete(@RequestBody Integer id) throws IOException {
        DBAcess dbAcess=new DBAcess();
        SqlSession sqlSession = dbAcess.getSqlSession();
        try {
            ProductMapper mapper =sqlSession.getMapper (ProductMapper.class);
            mapper.delete(id);
        }finally {
            sqlSession.close();
        }

    }


    @ResponseBody
    @RequestMapping("/insert")
    public void insert(@RequestBody Product product) throws IOException {
        DBAcess dbAcess=new DBAcess();
        SqlSession sqlSession = dbAcess.getSqlSession();
        try {
            ProductMapper mapper =sqlSession.getMapper (ProductMapper.class);
            mapper.insert(product);
        }finally {
            sqlSession.close();
        }

    }


}
