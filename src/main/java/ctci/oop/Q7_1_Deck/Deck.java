package ctci.oop.Q7_1_Deck;

import java.util.Stack;

public class Deck {

    private Stack<Card> deck = new Stack<>();

    public Card drawCard(){
        return deck.pop();
    }
}
