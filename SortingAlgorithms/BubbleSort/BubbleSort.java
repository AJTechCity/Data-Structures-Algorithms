public class BubbleSort{
    public static void main(String[] args){
        int[] unsorted_l1 = {4,1,5,2,3};

        System.out.println(arrayToString(sort(unsorted_l1)));
    }

    private static int[] sort(int[] array){
        boolean sorted = false;
        boolean swapped=false;

        while(!sorted){
            swapped=false;
            for (int i=0; i<array.length-1; i++){
                int tmp=array[i];
                if(tmp > array[i+1]){ //If current value is larger than next value in array perform a swap
                    System.out.println("Swapping " + array[i] + " with " + array[i+1]);
                    array[i] = array[i+1];
                    array[i+1] = tmp;
                    swapped=true;
                    //Swapp the two variables around and mark that there has been a swap in this pass
                }
            }

            if(!swapped){
                sorted = true; //If no swaps occurred then array must be sorted
            }
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