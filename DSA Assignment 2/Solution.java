import java.util.*;

public class Solution {
    // Question 1a
    public static boolean reachable1(String x, String y) {
        //IDEA: Create a counter for one's and zero's
        //A swap is similar to bubble sort algorithm meaning as long as x and y have the same number of 1's and 0's, they can be transformed into each other
        //Therfore: We are just going to see if number of 1's and 0's in x and y are the same, if so they are reachable
        int one_counter=0, zero_counter=0;

        for(int i=0; i<x.length(); i++) {
            //X will increase 1 and 0 counters
            if(x.charAt(i)=='1'){
                one_counter++;
            }else zero_counter++;

            //Y will decrease 1 and 0 counters
            if(y.charAt(i)=='1'){
                one_counter--;
            }else zero_counter--;

            //If they have the same number of 1's and 0's, after the iteration, the counters will both equal 0
        }

        if(one_counter==0 && zero_counter==0){
            return true;
        }else return false;
    }

    // Question 1b
    public static int distance1(String x, String y) {
        //Firstly check if y is reachable from x
        if(!reachable1(x,y)){
            return -1;
        }

        int swaps = 0;
        char[] arrX = x.toCharArray();
        char[] arrY = y.toCharArray();
        //O(n^2) due to nested for loops
        for(int i=0; i<arrX.length; i++) { //For each character in X
            for(int j=i+1; j<arrY.length; j++) { //Loop through each character in Y which has an index in front of X's character index
                if(arrX[j]==arrY[i] && arrX[i] != arrY[i]){ //If the character pair in X and Y is the opposite (i.e. 10 is opposite of 01) and if the first character is not in the correct position
                    while(j>i){ //While our pair is valid (second index is larger than first) - We are going to continually swap digits until the character ends up in correct place
                        char temp_char = arrX[j]; //Store the second character as temp variable
                        arrX[j] = arrX[j-1]; //swap second character with first
                        arrX[j-1] = temp_char; //Set first character as the stored second character using temp variable
                        swaps++; //Increase number of swaps
                        j--; //Go backwards towards first character to keep implement sequential swaps
                    }
                    break;
                }
            }
        }

        return swaps;
    }

    // Question 2
    public static int distance2(String x, String y) {

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(x);

        int steps=0;

        while(!queue.isEmpty()){
            int size = queue.size(); //Store in variable since queue.size() changes after each call
            for (int j=0; j<size; j++) {
                String current = queue.poll();

                if(current.equals(y)) return steps;

                for(int i=0; i<x.length()-2;i++){ //Cycle through triplets. String with length n will have n-2 triplets
                    String currentTriplet = current.substring(i,i+3);

                    String transformed=current;

                    if(currentTriplet.equals("110")){
                        transformed = current.substring(0,i).concat("001").concat(current.substring(i+3, x.length()));
                    }else if(currentTriplet.equals("011")){
                        transformed = current.substring(0,i).concat("100").concat(current.substring(i+3, x.length()));
                    }else if(currentTriplet.equals("101")){
                        transformed = current.substring(0,i).concat("110").concat(current.substring(i+3, x.length()));
                    }

                    if(!visited.contains(transformed)){
                        //Maximum of 2^(n-2) nodes are added to queue where n is the length of the string's x and y
                        queue.add(transformed);
                        visited.add(transformed);
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}