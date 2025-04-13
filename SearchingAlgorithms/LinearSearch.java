public class LinearSearch{
    public static void main(String[] args){
        int[] l1 = {1,2,4,5,22,42,55,70,75,89,546,854,978,8998,77897,1054872};

        int[] testCases = {75,55,232,54,1,546};

        for(int i=0; i<testCases.length; i++){
            int index = search(l1, testCases[i]);

            if(index>=0){
                System.out.println(testCases[i] + " - Element was found at index " + index);
            }else{
                System.out.println(testCases[i] + " - Element not found");
            }
        }
    }

    private static int search(int[] array, int item){
        //Performs a Linear Search and returns the index of the item if found. Otherwise, returns -1
        int index=-1;

        for(int i=0; i<array.length; i++){
            if(array[i]==item){
                index=i;
            }
        }

        return index;
    }
}