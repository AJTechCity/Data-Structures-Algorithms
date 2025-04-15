public class Test{

    /*
    Implement test scenario for our queue as per the lecture slides
     */

    public static void main(String[] args){
        Queue q = new Queue();

        q.enqueue(4);
        q.enqueue(3);
        q.enqueue(1);

        System.out.println(q.dequeue()); //Should output 4
    }
}