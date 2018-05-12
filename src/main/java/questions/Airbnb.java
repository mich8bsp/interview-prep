package questions;

import java.util.HashMap;
import java.util.Map;

/** Given a set of numbers in an array which represent a number of consecutive days of Airbnb reservation requested,
 * as a host, pick the sequence which maximizes the number of days of occupancy, at the same time,
 * leaving at least a 1-day gap in-between bookings for cleaning.
 *
 */
public class Airbnb {

    private static Map<Integer, Integer> cache = new HashMap<>();

    public static int calcBestReservations(int[] daysOfReservation){
        return calcBestReservations(daysOfReservation, 0, 0);
    }

    private static int calcBestReservations(int[] daysOfReservation, int index, int daysOfCleaning) {
        if(index>=daysOfReservation.length){
            return 0;
        }
        if(daysOfCleaning>0){
            return calcBestReservations(daysOfReservation, index+1, daysOfCleaning-1);
        }

        Integer res = cache.get(index);
        if(res!=null){
            return res;
        }
        res = Math.max(calcBestReservations(daysOfReservation, index+1, 0),
                calcBestReservations(daysOfReservation, index+1, 1) + daysOfReservation[index]);

        cache.put(index, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(calcBestReservations(new int[]{5,1,1,5}));
        cache.clear();
        System.out.println(calcBestReservations(new int[]{3,6,4}));
        cache.clear();
        System.out.println(calcBestReservations(new int[]{4,10,3,1,5}));
    }
}
