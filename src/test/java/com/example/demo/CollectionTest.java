package com.example.demo;

import lombok.Builder;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

public class CollectionTest {


    @Data
    @Builder
    private static class User {
        private String account;
        private String password;
        private String userName;
    }

    public static void main(String[] args) {
        List<User> users = Arrays.asList(User.builder().account("aaa").password("123").userName("shen").build(),
                User.builder().account("bbb").password("456").userName("yang").build(),
                User.builder().account("ccc").password("789").userName("han").build());
        // TODO: 查询用户名为ccc的user的密码是多少

    }
}
