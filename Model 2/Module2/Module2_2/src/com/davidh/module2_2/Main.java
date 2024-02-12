package com.davidh.module2_2;// then press Enter. You can now see whitespace characters in your code.
import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        LinkedList<Card> deck = createCard();

        for (int i = 0; i < deck.size(); i++) {
            System.out.println(deck.get(i));
        }

        LinkedList<Card> secondDeck = new LinkedList<Card>();
        Random rand = new Random();

        for (int i = 0; i < 7; i++) {
            int randCard = rand.nextInt(52-i);
            secondDeck.add(deck.get(randCard));
            deck.remove(randCard);
        }

        System.out.println("------------");

        for (int i = 0; i < secondDeck.size(); i++) {
            System.out.println(secondDeck.get(i));
        }

        System.out.println("------------");

        for (int i = 0; i < deck.size(); i++) {
            System.out.println(deck.get(i));
        }

    }

    /**
     * Generate a new deck of cards by looping through the four suits first, and then add each value of the suit into the list.
     * @return The generated deck
     */

    public static LinkedList<Card> createCard(){
        LinkedList<Card> deck = new LinkedList<Card>();

        for (int i = 0; i < 4; i++){
            for (int j = 1; j < 14; j++){
                deck.add(new Card(Suit.values()[i],j));
            }
        }
        return deck;
    }
}