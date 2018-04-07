package impl.algo;

public class BinarySearchImpl {

    public static int findIter(int val, int[] arr){
        int lowIdx = 0;
        int highIdx = arr.length;
        if(arr[lowIdx]>val || arr[highIdx-1]<val){
            return -1;
        }
        while(lowIdx<highIdx-1){
            int middleIdx = (lowIdx + highIdx)/2;
            if(arr[middleIdx]==val){
                return middleIdx;
            }else if(arr[middleIdx]>val){
                highIdx = middleIdx;
            }else{
                lowIdx = middleIdx;
            }
        }
        return (arr[lowIdx]==val) ? lowIdx : (arr[highIdx]==val) ? highIdx : -1;
    }

    public static int findRecursive(int val, int[] arr){
        return findRecursive(val, arr, 0, arr.length);
    }

    private static int findRecursive(int val, int[] arr, int lowIdx, int highIdx){
        if(highIdx - lowIdx<=1){
           return (arr[lowIdx]==val) ? lowIdx : (arr[highIdx]==val) ? highIdx : -1;
        }
        if(arr[0]>val || arr[arr.length-1]<val){
            return -1;
        }
        int middleIdx = (lowIdx+highIdx)/2;
        if(arr[middleIdx]==val){
            return middleIdx;
        }else if(arr[middleIdx]>val){
            return findRecursive(val, arr, lowIdx, middleIdx);
        }else{
            return findRecursive(val, arr, middleIdx, highIdx);
        }
    }

}
