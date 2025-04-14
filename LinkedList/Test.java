public class Test{
    public static void main(String[] args){
        DoublyLinkedList list = new DoublyLinkedList();

        System.out.println(list);

        list.insert_beginning(3);
        list.insert_beginning(2);
        list.insert_end(200);

        //List should be [2,3,200]

        System.out.println(list);
    }
}