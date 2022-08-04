package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GameTest {

    Player player1 = new Player(1, "Игрок1", 10);
    Player player2 = new Player(1, "Игрок2", 20);
    Player player3 = new Player(1, "Игрок3", 30);
    Player player4 = new Player(1, "Игрок4", 40);
    Player player5 = new Player(1, "Игрок5", 40);

    @Test
    public void ifPlayersRegisteredWithEqualsStrength() {
        Game registeredPlayers = new Game();
        registeredPlayers.register(player4);
        registeredPlayers.register(player5);

        int expected = 0;
        int actual = registeredPlayers.round(player4.name, player5.name);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ifPlayersRegisteredButFirstPlayerStrongest() {
        Game registeredPlayers = new Game();
        registeredPlayers.register(player1);
        registeredPlayers.register(player2);

        int expected = 1;
        int actual = registeredPlayers.round(player2.name, player1.name);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ifPlayersRegisteredButSecondPlayerStrongest() {
        Game registeredPlayers = new Game();
        registeredPlayers.register(player3);
        registeredPlayers.register(player4);

        int expected = 2;
        int actual = registeredPlayers.round(player3.name, player4.name);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ifFirstPlayerNotRegistered() {
        Game registeredPlayers = new Game();
        registeredPlayers.register(player1);
        registeredPlayers.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            registeredPlayers.round(player3.getName(), player2.getName());
        });
    }

    @Test
    public void ifSecondPlayerNotRegistered() {
        Game registeredPlayers = new Game();
        registeredPlayers.register(player1);
        registeredPlayers.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            registeredPlayers.round(player1.getName(), player3.getName());
        });
    }

    @Test
    public void ifBothPlayersNotRegistered() {
        Game registeredPlayers = new Game();
        registeredPlayers.register(player1);
        registeredPlayers.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            registeredPlayers.round(player3.getName(), player4.getName());
        });
    }
}
