package leetcode;

import leetcode.helper.Interval;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class OverlappingProblem {

    //check whether there is a time for which there is an overlap of more than overlapLimit
    public boolean isOverlappingMax(int overlapLimit, List<Interval> segmentList){
        List<Interval> byStartTime = segmentList.stream()
                .sorted(Comparator.comparingLong(x -> x.start))
                .collect(Collectors.toList());

        List<Interval> byEndTime = segmentList.stream()
                .sorted(Comparator.comparingLong(x -> x.end))
                .collect(Collectors.toList());

        int startIndex = 0;
        int endIndex = 0;

        Interval nextStartTime = byStartTime.get(startIndex);
        Interval nextEndTime = byEndTime.get(endIndex);

        int size = segmentList.size();
        int counter = 0;
        while(true){
            if(nextStartTime.start < nextEndTime.end){
                counter++;
                if(counter>overlapLimit){
                    return true;
                }
                startIndex++;
                if(startIndex>=size){
                    return false;
                }
                nextStartTime = byStartTime.get(startIndex);
            }else if(nextStartTime.start > nextEndTime.end){
                counter--;
                nextEndTime = byEndTime.get(++endIndex);
            }else{
                startIndex++;
                if(startIndex>=size){
                    return false;
                }
                nextStartTime = byStartTime.get(startIndex);
                nextEndTime = byEndTime.get(++endIndex);
            }
        }
    }

    public static void main(String[] args) {
        List<Interval> segmentList = new LinkedList<>();

        segmentList.add(new Interval(1,5));
        segmentList.add(new Interval(2,5));
        segmentList.add(new Interval(3,6));
        segmentList.add(new Interval(7,10));
        segmentList.add(new Interval(9,16));

        OverlappingProblem prob = new OverlappingProblem();
        System.out.println(prob.isOverlappingMax(3, segmentList));
        System.out.println(prob.isOverlappingMax(2, segmentList));
    }
}
