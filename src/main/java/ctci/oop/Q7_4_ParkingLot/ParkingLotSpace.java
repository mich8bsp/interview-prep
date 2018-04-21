package ctci.oop.Q7_4_ParkingLot;

public class ParkingLotSpace {

    private boolean isVacant;
    private int rowNum;
    private int spaceNum;

    public ParkingLotSpace(int rowNum, int spaceNum) {
        this.rowNum = rowNum;
        this.spaceNum = spaceNum;
        this.isVacant = true;
    }

    public void park(){
        isVacant=false;
    }

    public void unpark(){
        isVacant = true;
    }

    public boolean isVacant() {
        return isVacant;
    }
}
