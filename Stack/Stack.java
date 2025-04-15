class Stack{

    /*
    - An implementation of the Stack ADT (Abstract Data Type) using a LinkedList-type Data Structure
    since insert_beginning and delete_beginning are both O(1)
    - Will need to slightly change the delete_beginning function to delete the first item AND return it to the user
     */

    private static StackItem stack = null;

    public static void push(int val){
        StackItem newItem = new StackItem();
        newItem.val = val;
        newItem.next = stack;
        stack = newItem;
    }

    public static StackItem pop(){
        if(isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        //Store the first stack item in a variable, then set the stack to now start at the next item and return the removed item to the user
        StackItem item = stack;
        stack = stack.next;
        return item;
    }

    public static boolean isEmpty(){
        //Stack is empty if the first item (stored in stack variable) is null
        return stack == null;
    }
}