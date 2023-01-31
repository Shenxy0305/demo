package com.example.demo;

import lombok.Builder;
import lombok.Data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectionTest {


    @Data
    private static class User {
        private String account;
        private String password;
        private String userName;
    }

    public static void main(String[] args) {
        // 健值对是 一个key和一个value
        // Map结构可以通过key获得对应的value

        // 新增一个Map对象 key是Integer类型 value是String类型
        Map<Integer, String> map = new HashMap<>();

        // 将一个健值对放入这个map key是1 value是aaa
        map.put(1, "aaa");

        // 通过key获取map当中的值 key是1
        String str = map.get(1);

        // TODO: 创建一个User对象 将这个对象的account设为test password设为aaa

        // TODO: 创建一个User对象 将这个对象的account设为bbb password设为123

        // TODO: 将这两个对象放入map当中 key是user对象的account value是这个user对象

        // TODO: 获取account是bbb的user对象

        // TODO: 获取account是test的user对象的password
    }
}
