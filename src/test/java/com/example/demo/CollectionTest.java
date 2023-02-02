package com.example.demo;

import lombok.Builder;
import lombok.Data;
import org.assertj.core.api.MapAssert;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class CollectionTest {


    @Data
    @Builder
    private static class Team {
        private String name;
        private List<User> list;
    }

    @Data
    @Builder
    private static class User {
        private String account;
        private String password;
        private String userName;
    }

    public static void main(String[] args) {
        Team team1 = Team.builder().name("team1").list(new ArrayList<>()).build();
        Team team2 = Team.builder().name("team2").list(new ArrayList<>()).build();

        for (int i = 0; i < 10; i++) {
            team1.getList().add(User.builder().account("Team1 account" + i).password("Team1 password" + i).build());
            team2.getList().add(User.builder().account("Team2 account" + i).password("Team2 password" + i).build());
        }


        // 有两个Team team1 team2 没个Team里都有十个User

        // TODO: 打印team1 里边 第三个user的account

        // TODO: 打印team2 里边 第十个user的password

















    }
}
