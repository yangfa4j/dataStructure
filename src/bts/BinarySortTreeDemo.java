package bts;

/**
 * @Date 2019/11/20
 * @Author yangfa
 * @Description
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int [] arr = {7,3,10,12,5,1,9};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i : arr) {
             binarySortTree.add(new Node(i));
        }
        binarySortTree.lastOrder();
    }
}

class BinarySortTree{
    private Node root;

    public void add(Node node){
        if (root == null){
            root = node;
        }else {
            root.add(node);
        }
    }

    public void infixOrder(){
        if (root != null) {
            root.infixOrder();
        }else {
            System.out.println("空树没法遍历");
        }
    }
    public void preOrder(){
        if (root != null) {
            root.preOrder();
        }else {
            System.out.println("空树没法遍历");
        }
    }
    public void lastOrder(){
        if (root != null) {
            root.lastOrder();
        }else {
            System.out.println("空树没法遍历");
        }
    }

}



class Node {
    Integer value;
    Node lrft;
    Node right;

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public Node(Integer value) {
        this.value = value;
    }

    // 递归添加
    public void add(Node node){
        if (node == null) {
            return;
        }
        if (node.value < this.value){
            // 添加到左边
            if (this.lrft == null) {
                this.lrft = node;
            }else {
                this.lrft.add(node);
            }
        }else {
            // 添加到右边
            if (this.right == null) {
                this.right = node;
            }else {
                this.right.add(node);
            }
        }

    }

    public void infixOrder(){
        if (this.lrft != null){
            this.lrft.infixOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.infixOrder();
        }
    }

    public void preOrder(){
        System.out.println(this);
        if (this.lrft != null){
            this.lrft.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }

    public void lastOrder(){
        if (this.lrft != null){
            this.lrft.lastOrder();
        }
        if (this.right != null){
            this.right.lastOrder();
        }
        System.out.println(this);
    }


}
