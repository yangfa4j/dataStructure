package tree;

/**
 * @Date 2019/9/9
 * @Author YF
 * @Description
 */
public class BinaryTree {

    public static void main(String[] args) {

    }
}

class HeroNode{
    private int no;
    private String name;
    /**
     * 左节点
     */
    private HeroNode left;

    /**
     * 右节点
     */
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 先序遍历
     */
    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void midOrder(){
        if (this.left != null){
            this.left.midOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.midOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder(){
        if (this.left != null){
            this.left.midOrder();
        }
        if (this.right != null){
            this.right.midOrder();
        }
        System.out.println(this);
    }

    public static void main(String[] args){
        int[] array={49,38,65,97,76,13,27,49,78,34,12,64,1};
        System.out.println("排序之前：");
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        //希尔排序
        int gap = array.length;
        while (true) {
            gap /= 2;   //增量每次减半
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < array.length; j += gap) {//这个循环里其实就是一个插入排序
                    int temp = array[j];
                    int k = j - gap;
                    while (k >= 0 && array[k] > temp) {
                        array[k + gap] = array[k];
                        k -= gap;
                    }
                    array[k + gap] = temp;
                }
            }
            if (gap == 1)
                break;
        }

        System.out.println();
        System.out.println("排序之后：");
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
}
