public class Queue{
    public static QueueItem queue = null;
    public static QueueItem end = null;

    /*
    - Implementation of a Queue Data Structure using a linked list that also stores the last item in a given queue so we can easily enqueue items
    - Ensures insert_end and delete_beginning run in O(1) time
     */

    public static void enqueue(int val){
        QueueItem newItem = new QueueItem();
        newItem.val = val;

        if(!isEmpty()){ //if the queue is not currently empty, we must set the QueueItem.next attribute of our last queue item to be the new item
            end.next = newItem;
        }else{ //if the queue is empty, we must set our new last item as the first QueueItem also
            queue = newItem;
        }
        end = newItem;
    }

    public static QueueItem dequeue(){
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }

        QueueItem cur = queue;
        if(cur.next==null){ //If the queue is about to be emptied - ensure that the end item is set as null, otherwise can stay as-is
            end = null;
        }
        queue = queue.next;

        return cur;
    }

    public static QueueItem top(){
        return queue;
    }

    public static boolean isEmpty(){
        return queue == null;
    }
}