package com.example.demo.games;

import lombok.Builder;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

public class RoShamBoGame {

    private static final String PLAYER_A = "甲";
    private static final String PLAYER_B = "乙";
    private static final String SCISSORS = "剪刀";
    private static final String STONE = "石头";
    private static final String CLOTH = "布";
    private static final String WIN = "胜!";
    private static final String PEACE = "平局!";
    private static final List<String> FIGHT_LIST = Arrays.asList(SCISSORS, STONE, CLOTH);
    private static final Integer TIMES = 100;

    @Data
    @Builder
    private static class Player {
        private String name;
        private String fight;
        private Boolean result;
        private Integer winCount;
        private void win() {
            this.result = true;
            winCount++;
        }

        private void rollBack() {
            this.result = false;
        }

        private void random() {
            int random = (int) (Math.random() * 3);
            this.fight = FIGHT_LIST.get(random);
        }
    }

    public static void main(String[] args) {
        Player playerA = Player.builder().name(PLAYER_A).result(false).winCount(0).build();
        Player playerB = Player.builder().name(PLAYER_B).result(false).winCount(0).build();

        for (int i = 0; i < TIMES; i++) {
            round(playerA, playerB);
        }
        System.out.println(playerA.getName() + "胜利次数: " + playerA.getWinCount());
        System.out.println(playerB.getName() + "胜利次数: " + playerB.getWinCount());
        System.out.println("平局次数: " + (TIMES - playerA.getWinCount() - playerB.getWinCount()));
    }

    private static void round(Player a, Player b) {
        a.random();
        b.random();
        fight(a, b);
        print(a, b);
    }

    private static void print(Player a, Player b) {
        String result = a.result ? a.getName() + WIN : b.getResult() ? b.getName() + WIN : PEACE;
        System.out.println(a.getName() + ":" + a.getFight() + " <---> " + b.getName() + ":" + b.getFight() + " 结果: " + result);
        a.rollBack();
        b.rollBack();
    }

    private static void fight(Player a, Player b) {
        switch (a.getFight()) {

            // a -> 剪刀
            case SCISSORS:
                switch (b.getFight()) {
                    // b -> 石头
                    case STONE:
                        b.win();
                        return;
                    // b -> 布
                    case CLOTH:
                        a.win();
                        return;
                }
                break;

            // 石头
            case STONE:
                switch (b.getFight()) {
                    // b -> 剪刀
                    case SCISSORS:
                        a.win();
                        return;
                    // b -> 布
                    case CLOTH:
                        b.win();
                        return;
                }
                break;

            // 布
            case CLOTH:
                switch (b.getFight()) {
                    // b -> 剪刀
                    case SCISSORS:
                        b.win();
                        return;
                    // b -> 石头
                    case STONE:
                        a.win();
                }
        }
    }
}
