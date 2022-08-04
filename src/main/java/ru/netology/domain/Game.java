package ru.netology.domain;

import java.util.ArrayList;

public class Game {
    // Список
    ArrayList<Player> registeredPlayers = new ArrayList<>();

    // Метод регистрации игрока
    public void register(Player player) {
        registeredPlayers.add(player);
    }

    // Метод соревнования между двумя игроками
    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;
        for (Player player : registeredPlayers) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }
        if (player1 == null) {
            throw new NotRegisteredException(
                    playerName1 + "не зарегистрирован");
        }
        if (player2 == null) {
            throw new NotRegisteredException(
                    playerName2 + "не зарегистрирован");
        }
        if (player1.getStrength() == player2.getStrength()) {
            return 0;
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else {
            return 2;
        }
    }
}
