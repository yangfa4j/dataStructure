package mystack;

/**
 * @Date 2019/7/22
 * @Author YF
 * @Description 定义一个栈，用数组来实现
 */
public class ArrayStackDemo {
    public static void main(String[] args) {

    }
}

class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int x) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        stack[++top] = x;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        return stack[top--];
    }

    public void list(ArrayStack arrayStack) {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(arrayStack.stack[i]);
        }
    }
}
