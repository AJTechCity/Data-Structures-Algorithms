public class QuickSort{
    public static void main(String[] args){
        int[] unsorted_l1 = {4,1,5,2,3};

        System.out.println(arrayToString(sort(unsorted_l1)));
    }

    private static int[] sort(int[] array){
        return sort(array, 0, array.length-1);
    }

    private static int[] sort(int[] array, int left, int right){
        if(left<right){
            int pivotIndex = partition(array, left, right);
            sort(array, left, pivotIndex-1);
            sort(array, pivotIndex+1, right);
        }

        return array;
    }

    private static int partition(int[] array, int left, int right){
        int pivot = array[left];

        int small = left;
        int big = right;
        while (small<big){
            while(array[small] < pivot){
                small++;
            }

            while(array[big] > pivot){
                big--;
            }

            int tmp = array[small];
            array[small] = array[big];
            array[big] = tmp;
            if(small < big && array[small] == array[big]) {
                small++;
            }
        }

        return big;
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