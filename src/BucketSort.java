import com.sun.java.swing.plaf.windows.WindowsOptionPaneUI;

import java.util.*;

public class BucketSort {


    public static void main(String args[]) {

        int[] intArray = {54, 46, 83, 66, 95, 92, 43};
        bucketSort(intArray);
        System.out.println("Sorted Array is below : ");
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }

    }

    public static void bucketSort(int[] input) {
        //Method 1 - Using ArrayList as buckets
        List<Integer>[] buckets = new List[10];
        //Method 2 - Using LinkedList as buckets
        //List<Integer>[] buckets = new LinkedList[10];
        //Initialize each index in intArray to be a array list
        for(int i=0;i<buckets.length;i++){
            buckets[i]=new ArrayList<>();
        }
        //Put each element from the array into corresponding buckets
        for(int i=0;i<input.length;i++){
            buckets[hash(input[i])].add(input[i]);
        }

        //Print bucketed array elements
        System.out.println("Bucketed elements from the array : ");
        for(int i=0;i<buckets.length;i++){
            ListIterator<Integer> iterator = buckets[i].listIterator();
            while(iterator.hasNext()){
                System.out.print(iterator.next() + "->");
            }
            System.out.println("null");
        }

        //Above buckets are unsorted internally, now sort the buckets using Collections Sort method
        //Collections.sort uses adaptive merge method
        for(List bucket : buckets){
            Collections.sort(bucket);
        }

        //Merge the sorted buckets back into array
        int j=0;
        for(int i=0;i< buckets.length;i++){
            for(int value : buckets[i]){
                input[j++]=value;
            }
        }
    }

    public static int hash(int element){
        return element/10;
    }
}
