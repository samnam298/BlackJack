package com.pluralsight;

import java.util.*;

public class BlackJackGame {
    private List<Player> players;
    private Deck deck;

    public BlackJackGame() {
        players = new ArrayList<>();
        deck = new Deck();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter name for Player " + (i + 1) + ": ");
            String name = scanner.nextLine();
            players.add(new Player(name));
        }

        // Deal two cards to each player
        for (Player player : players) {
            player.addCard(deck.dealCard());
            player.addCard(deck.dealCard());
        }

        // Show hands
        for (Player player : players) {
            player.showHand();
        }

        // Determine winner
        determineWinner();
    }

    private void determineWinner() {
        Player winner = null;
        int bestScore = 0;

        for (Player player : players) {
            int score = player.getScore();
            if (score <= 21 && score > bestScore) {
                bestScore = score;
                winner = player;
            }
        }

        if (winner != null)
            System.out.println("🏆 Winner: " + winner.getName() + " with " + bestScore + " points!");
        else
            System.out.println("😢 Everyone busted. No winner this round.");
    }
}
