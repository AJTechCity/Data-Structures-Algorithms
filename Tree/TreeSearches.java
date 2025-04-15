public class TreeSearches{
    public boolean binaryTree_dfs(BinaryNode root, int val){
        //Performs a depth-first search to see if the integer value 'val' is contained within the given tree

        if(root == null){
            return false;
        }

        return (
                binaryTree_dfs(root.left, val)
                || root.val == val
                || binaryTree_dfs(root.right, val)
                );
    }

    public boolean binaryTree_bfs(BinaryNode root, int val){
        if(root == null){
            return false;
        }

        BinaryTree t = new BinaryTree();
        t.tree = root;

        int treeSize = t.flatten().length;

        int[] queue = new int[treeSize/2];

        while(queue.length > 0){ //While there are still nodes to check
            int siblingNodeCount = queue.length;
            for(int i=0; i<siblingNodeCount; i++){
                
            }
        }
    }
}