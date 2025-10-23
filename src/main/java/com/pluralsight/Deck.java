package com.pluralsight;

import java.util.*;

public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for (String suit : suits) {
            for (String value : values) {
                cards.add(new Card(suit, value));
            }
        }

        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card dealCard() {
        if (cards.isEmpty()) {
            System.out.println("Deck is empty! Creating and shuffling a new one...");
            return null;
        }
        Card dealt = cards.remove(0);
        dealt.flip(); // make sure it’s face up when dealt
        return dealt;
    }
}
