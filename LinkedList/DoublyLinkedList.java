public class DoublyLinkedList{
    public static DoubleLinkedNode listStart = null;
    public static DoubleLinkedNode listEnd = null;

    public static boolean isEmpty(){
        return listStart==null;
    }

    public static void insert_beginning(int value){
        DoubleLinkedNode newNode = new DoubleLinkedNode();
        newNode.val = value;
        newNode.next = listStart;
        newNode.prev=null;
        if(isEmpty()){
            listEnd = newNode;
        }else{
            //If list isn't currently empty, set the current starting node's prev attribute to point to the new starting node
            listStart.prev=newNode;
        }
        listStart = newNode;
    }

    public static void delete_beginning(){
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }

        if(listStart.next == null){ //If list is about to be emptied, clear listEnd item
            listEnd = null;
        }
        listStart = listStart.next;

        if(listStart != null){ //If list isn't empty after removing the start item, update the new beginning item's prev attribute to point to null
            listStart.prev=null;
        }
    }

    public static void insert_end(int value){
        DoubleLinkedNode newNode = new DoubleLinkedNode();
        newNode.val = value;
        newNode.prev = listEnd;
        listEnd.next = newNode; //Update the current last item's next attribute to point to the new end item
        listEnd = newNode;
    }

    public static void delete_end(){
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }

        if(listEnd.prev == null){ //If list is about to be emptied, remove the first item too
            listStart = null;
        }

        listEnd = listEnd.prev; //Update the new listEnd to be the 2nd last item
        listEnd.next = null; //Update the new last item's next attribute to point to nothing
    }

    public static int value_at(int index){
        DoubleLinkedNode cur=listStart;
        for(int i=0;i<index;i++){
            if(cur.next == null){
                throw new RuntimeException("Index out of Bounds");
            }
            cur = cur.next;
        }

        return cur.val;
    }

    public String toString(){
        String output = "[";
        DoubleLinkedNode cur = listStart;

        if (!isEmpty()) {
            while(cur.next!=null){
                output = output + cur.toString() + ", ";
                cur = cur.next;
            }

            output = output + cur.toString() + "]";
        }else{
            output = "[]";
        }

        return output;
    }
}