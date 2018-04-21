package ctci.oop.Q7_1_Deck;

public enum ECardShape {
    JACK(11), QUEEN(12), KING(13), ACE(1);

    private final int numericValue;

    ECardShape(int val) {
        this.numericValue = val;
    }

    public static ECardShape fromNumericValue(int numericValue) {
        for(ECardShape cardShape : ECardShape.values()){
            if(cardShape.numericValue==numericValue){
                return cardShape;
            }
        }
        return null;
    }
}
