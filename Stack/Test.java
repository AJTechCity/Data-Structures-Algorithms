public class Test{
    public static void main(String[] args){
        Stack stack = new Stack();

        //Perform test based off of examples in slideshow
        stack.push(3);
        stack.push(5);
        stack.push(2);
        System.out.println(stack.pop()); //Should output '2'
    }
}