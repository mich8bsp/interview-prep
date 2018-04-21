package ctci.oop.Q7_1_Deck;

public class CardValue {
    private int numericValue;
    private ECardShape shape;

    public CardValue(int numericValue){
        if(numericValue>=2 && numericValue<=10){
            this.numericValue = numericValue;
        }else{
            ECardShape shape = ECardShape.fromNumericValue(numericValue);
            if(shape==null){
                throw new IllegalArgumentException();
            }
            this.shape = shape;
            this.numericValue = numericValue;
        }
    }
}
