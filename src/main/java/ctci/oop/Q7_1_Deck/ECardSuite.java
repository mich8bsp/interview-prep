package ctci.oop.Q7_1_Deck;

public enum ECardSuite {
    HEARTS(ECardColor.RED), DIAMONDS(ECardColor.RED), CLUBS(ECardColor.BLACK), SPADES(ECardColor.BLACK);

    private ECardColor color;

    ECardSuite(ECardColor color) {
        this.color = color;
    }

    public ECardColor getColor() {
        return color;
    }
}
