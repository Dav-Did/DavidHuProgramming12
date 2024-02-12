package com.davidh.module2_2;

public class Card{
    private Suit suit;
    private Integer value;
    private Boolean face;

    /**
     * com.davidh.module2_2.Card constructor with suit and value parameter
     * @param suit
     * @param value
     */

    public Card(Suit suit, Integer value) {
        this.suit = suit;
        this.value = value;
        this.face = value > 10;
    }


    /**
     * com.davidh.module2_2.Card Getter and Setter
     * @param
     * @return
     */

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
        return "com.davidh.module2_2.Card: " + value + " of " + suit + ", Face: " + face;
    }
}