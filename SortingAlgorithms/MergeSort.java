public class MargeSort{
    public static void main(String[] args){
        int[] unsorted_l1 = {4,1,5,2,3};

        System.out.println(arrayToString(sort(unsorted_l1)));
    }

    private static int[] sort(int[] array, int left, int right){
        //Recursively call the sort function on each half of the given array - Essentially splits the array in half recursively until we have arrays of size 1 being merged together and then forms the final array
        if(left == right){
            return new int[] {array[left] };
        }

        int mid = (left+right)/2;
        return merge(sort(array,left,mid), sort(array, mid+1, right));
    }

    private static int[] sort(int[] array){
        return sort(array, 0, array.length-1);
    }

    private static int[] merge(int[] a, int[] b){
        //Merge 2 sorted arrays a and b

        //Idea: have 2 counters i and j which respectively represent the current position of a[] and b[]
        // While (i<=a.length && j<= b.length - See which is larger a[i] or b[j] and then insert that into the new tmp array
        //Return a sorted array in O(n) time

        int[] tmp = new int[a.length + b.length];

        int i=0, j=0, k=0; //k is counter for current tmp array position

        while(i<a.length || j<b.length){

            if(i >= a.length){
                tmp[k] = b[j];
                j++;
            }else if(j>=b.length){
                tmp[k] = a[i];
                i++;
            }else if(a[i]<b[j]){
                tmp[k] = a[i];
                i++;
            }else if(a[i]>b[j]){
                tmp[k] = b[j];
                j++;
            }else{
                tmp[k] = a[i];
                i++;
            }

            k++;
        }

        return tmp;
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