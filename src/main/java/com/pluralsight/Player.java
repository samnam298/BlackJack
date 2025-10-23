package com.pluralsight;

import java.util.*;

public class Player {
    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public int getScore() {
        int total = 0;
        int aceCount = 0;

        for (Card card : hand) {
            int value = card.getPointValue();
            total += value;
            if (card.toString().startsWith("A")) aceCount++;
        }

        // If total > 21, reduce Aces from 11 → 1
        while (total > 21 && aceCount > 0) {
            total -= 10;
            aceCount--;
        }

        return total;
    }

    public String getName() {
        return name;
    }

    public void showHand() {
        System.out.println(name + "'s Hand:");
        for (Card card : hand) {
            System.out.println("  " + card);
        }
        System.out.println("Total Points: " + getScore() + "\n");
    }
}
