import java.util.Arrays;

public class Test{
    public static void main(String[] args){
        BinaryTree t = new BinaryTree();

        BinaryNode root = new BinaryNode();
        BinaryNode rootL = new BinaryNode();
        BinaryNode rootR = new BinaryNode();
        BinaryNode rootRL = new BinaryNode();
        BinaryNode rootRR = new BinaryNode();
        BinaryNode rootRLR = new BinaryNode();

        root.val = 33;
        rootL.val = 10;
        rootR.val = 30;
        rootRL.val = 21;
        rootRR.val = 1;
        rootRLR.val = 25;

        rootRL.right = rootRLR;
        rootR.left = rootRL;
        rootR.right = rootRR;
        root.right = rootR;
        root.left = rootL;

        t.tree = root;

        int[] flat = t.flatten();

        System.out.println(Arrays.toString(flat)); //[10, 33, 21, 25, 30, 1]


        System.out.println(t.dfs(t.tree, 4)); //False
        System.out.println(t.dfs(t.tree, 25)); //True

        System.out.println(t.bfs(1)); //True
        System.out.println(t.bfs(174)); //False
    }
}