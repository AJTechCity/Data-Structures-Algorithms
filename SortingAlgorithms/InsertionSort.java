public class InsertionSort{
    public static void main(String[] args){
        int[] unsorted_l1 = {4,1,5,2,3};

        System.out.println(arrayToString(sort(unsorted_l1)));
    }

    private static int[] sort(int[] array){
        //Perform in-line Insertion sort on an assumed unsorted array

        int unsortedStart = 1; //Divide the array into 2 halves - Sorted at the start and unsorted from index 1 onwards

        while(unsortedStart<array.length){ //Repeat the loop until all array items are in the "Sorted" section
            int next = array[unsortedStart]; //Get the value of the next item in the "unsorted" part of the array

            boolean inserted=false;

            while(!inserted){ //While we haven't inserted the unsorted item into the sorted part of the array
                int curIndex=unsortedStart-1; //Create a currentIndex marker to show where we are in the insertion/swapping part of the alogrithm
                if(array[curIndex] > next){ //If the current item we are checking is larger than the item we want to insert, then we want to swap them around and keep looking further into the sorted array for the correct position
                    int tmp = array[curIndex]; //Store temp variable
                    //Initiate swap of variable and set the currentIndex of the number we are looking at to the item before the one we are looking at now
                    array[curIndex]=next;
                    array[curIndex+1]=tmp;
                    curIndex--;
                }else{
                    //If the item behind the one we are inserting is smaller, then the item we are inserting is in the correct position
                    inserted=true;
                }
            }

            unsortedStart++; //Since we have sorted the item, we can Decrease the size of the "Unsorted" part of our array
        }

        return array;
    }

    private static String arrayToString(int[] array){
        String s = "[";
        for (int i=0; i<array.length-1; i++){
            s += array[i] + ", ";
        }

        s += array[array.length-1] + "]";

        return s;
    }
}