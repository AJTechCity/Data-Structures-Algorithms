public class DoubleLinkedNode extends Node{
    int val;
    DoubleLinkedNode next=null;
    DoubleLinkedNode prev=null;

    public String toString(){
        String prevStr = "null";
        String nextStr = "null";

        if (prev != null){
            prevStr = Integer.toString(prev.val);
        }

        if(next != null){
            nextStr = Integer.toString(next.val);
        }
        return "{val: " + val + ", prev: " + prevStr + ", next: " + nextStr + "}";
    }
}