public class BinaryTree implements BaseTree{
    public BinaryNode tree = null;

    public int[] flatten(){
        return _flatten(tree);
    }

    private int[] _flatten(BinaryNode node){
        if(node == null){
            return new int[0];
        }

        int[] left = _flatten(node.left);
        int[] right = _flatten(node.right);

        return combineArrays(left, node.val, right);
    }

    private int[] combineArrays(int[] arr1, int curVal, int[] arr2){
        int[] ret = new int[arr1.length + arr2.length + 1];

        for(int i = 0; i < arr1.length; i++){
            ret[i] = arr1[i];
        }

        ret[arr1.length] = curVal;

        for(int i = 0; i < arr2.length; i++){
            ret[arr1.length+1+i] = arr2[i];
        }

        return ret;
    }

    public boolean dfs(BinaryNode root, int val){
        //Performs a depth-first search to see if the integer value 'val' is contained within the given tree

        if(root == null){
            return false;
        }

        return (
                dfs(root.left, val)
                        || root.val == val
                        || dfs(root.right, val)
        );
    }

    public boolean bfs(int val){
        if(tree == null){
            return false;
        }

        Queue queue = new Queue();

        queue.enqueue(tree);

        while(queue.size() > 0){ //While there are still nodes to check
            int siblingNodeCount = queue.size();
            for(int i=0; i<siblingNodeCount; i++){
                BinaryNode curItem = queue.dequeue().node;
                if(curItem == null){
                    continue;
                }

                if(curItem.val == val){
                    return true;
                }
                queue.enqueue(curItem.left);
                queue.enqueue(curItem.right);
            }
        }

//        Queue queue = new Queue();
//        BinaryNode n = new BinaryNode();
//        n.val = 3;
//        System.out.println(queue.size());
//        queue.enqueue(n);
//        System.out.println(queue.size());
//        queue.enqueue(n);
//        System.out.println(queue.size());
//
//        BinaryNode t = queue.dequeue().node;
//        System.out.println(Integer.toString(t.val));
//        System.out.println(queue.size());

        //If loop finishes, item wasn't found
        return false;
    }
}

class Queue{
    /*
    Implemented a Queue DataType so we can queue the sibling nodes on a given level and they can all be checked (hence, a breadth-first search)
     */
    QueueItem start;
    QueueItem end;

    public QueueItem dequeue(){
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }

        QueueItem item = start;
        if(start.next == null){ //If start item=end item, a.k.a last item in queue
            end = null;
        }
        start = start.next;
        return item;
    }

    public void enqueue(BinaryNode node){
        QueueItem item = new QueueItem();
        item.node = node;
        if(isEmpty()){
            start = item;
            end = item;
        }else{
            end.next=item;
        }
    }

    public boolean isEmpty(){
        return (start == null || end == null);
    }

    public int size(){
        int count=0;
        if(isEmpty()){
            return count;
        }

        QueueItem cur = start;
        while(cur != null){
            count++;
            cur = cur.next;
        }

        return count;
    }
}

class QueueItem{
    /*
    Used for the Queue implementation
     */
    BinaryNode node;
    QueueItem next;
}