package ctci.oop.Q7_4_ParkingLot;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Optional;

public class ParkingLot {

    private ParkingLotRow[] rows = new ParkingLotRow[16];

    class ParkingLotRow{
        private int rowNumber;
        private ParkingLotSpace[] parkingLotSpaces;

        public ParkingLotRow(int rowNumber, int size){
            parkingLotSpaces = new ParkingLotSpace[size];
            for(int i=0;i<size;i++){
                parkingLotSpaces[i] = new ParkingLotSpace(rowNumber, i);
            }
        }

        public boolean hasVacantPlaces(){
            return Arrays.stream(parkingLotSpaces)
                    .anyMatch(ParkingLotSpace::isVacant);
        }


        public Optional<ParkingLotSpace> getVacantPlace() {
            return Arrays.stream(parkingLotSpaces)
                    .filter(ParkingLotSpace::isVacant)
                    .findFirst();
        }
    }

    public ParkingLotSpace getVacantSpace(){
        return Arrays.stream(rows)
                .filter(ParkingLotRow::hasVacantPlaces)
                .map(ParkingLotRow::getVacantPlace)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst()
                .orElse(null);
    }
}
