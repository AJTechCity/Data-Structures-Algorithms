public class LinkedList{
    public static Node list = null;

    public static void main(String[] args){
        insert_beginning(1);
        insert_beginning(10);
        insert_beginning(2);
        insert_beginning(5);
        insert_end(1000);

        System.out.println(value_at(4));

        delete_end();
        System.out.println(value_at(4));
    }

    public static void insert_beginning(int value){
        Node newNode = new Node();
        newNode.val = value;
        newNode.next = list;
        list = newNode;
    }

    public static boolean isEmpty(){
        return list == null;
    }

    public static void delete_beginning(){
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }

        list = list.next;
    }

    public static int value_at(int index){
        Node cur=list;
        for(int i=0;i<index;i++){
            if(cur.next == null){
                throw new RuntimeException("Index out of Bounds");
            }
            cur = cur.next;
        }

        return cur.val;
    }

    public static void insert_end(int value){
        Node newNode = new Node();
        newNode.val = value;

        Node cur = list;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = newNode;
    }

    public static void delete_end(){
        Node cur = list;
        Node prev=null;
        while(cur.next != null){
            prev=cur;
            cur=cur.next;
        }

        prev.next=null;
    }

}