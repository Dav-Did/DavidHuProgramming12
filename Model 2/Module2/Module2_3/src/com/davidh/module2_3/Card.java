package com.davidh.module2_3;

public class Card implements Comparable<Card>{
    private Suit suit;
    private Integer value;
    private Boolean face;

    /**
     * com.davidh.module2_3.Card constructor with suit and value parameter
     * @param suit
     * @param value
     */

    public Card(Suit suit, Integer value) {
        this.suit = suit;
        this.value = value;
        this.face = value > 10;
    }

    public Suit getSuit(){return suit;}

    public Integer getValue() {
        return value;
    }

    public Boolean getFace() {return face;}

    public void setSuit(Suit suit) {
        this.suit = suit;
    }



    public void setValue(Integer value) {
        this.value = value;
        this.face = value < 10;
    }




    @Override
    public String toString() {
        return "com.davidh.module2_3.Card: " + value + " of " + suit + ", Face: " + face;
    }

    @Override
    public int compareTo(Card o) {

        return 0;
    }
}