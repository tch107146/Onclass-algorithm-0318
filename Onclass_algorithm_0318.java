import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 國立澎湖科技大學 資訊工程學系
 * Author: 蔡晟旭 (Alexen)
 * Course: Algorithms
 * Assignment 1: Stack operations (Integrated with Queue)
 */
public class Onclass_algorithm_0318 {

    // 實作 Stack (LIFO)
    static class CustomStack<T> {
        // 使用 Java ArrayList 作為動態陣列來實作 Stack
        private ArrayList<T> elements;

        public CustomStack() {
            elements = new ArrayList<>();
        }

        // push 操作：將元素加入 Stack 頂端
        // 時間複雜度：Amortized O(1)
        public void push(T item) {
            elements.add(item);
            System.out.println("Stack push: " + item);
        }

        // pop 操作：移除並回傳 Stack 頂端的元素
        // 時間複雜度：O(1)
        public T pop() {
            if (isEmpty()) {
                System.out.println("Stack 已經空了！");
                return null;
            }
            T item = elements.remove(elements.size() - 1);
            System.out.println("Stack pop: " + item);
            return item;
        }

        public boolean isEmpty() {
            return elements.isEmpty();
        }
    }

    // 實作 Queue (FIFO)
    static class CustomQueue<T> {
        // 使用 LinkedList 來實作 Queue，確保前後端操作皆為 O(1)
        private LinkedList<T> elements;

        public CustomQueue() {
            elements = new LinkedList<>();
        }

        // enqueue 操作：將元素加入 Queue 尾端
        // 時間複雜度：O(1)
        public void enqueue(T item) {
            elements.addLast(item);
            System.out.println("Queue enqueue: " + item);
        }

        // dequeue 操作：從 Queue 前端取出並移除元素
        // 時間複雜度：O(1)
        public T dequeue() {
            if (isEmpty()) {
                System.out.println("Queue 已經空了！");
                return null;
            }
            T item = elements.removeFirst();
            System.out.println("Queue dequeue: " + item);
            return item;
        }

        // peek 操作：查看 Queue 前端的元素但不移除
        // 時間複雜度：O(1)
        public T peek() {
            if (isEmpty()) {
                return null;
            }
            T item = elements.getFirst();
            System.out.println("Queue peek: " + item);
            return item;
        }

        public boolean isEmpty() {
            return elements.isEmpty();
        }
    }

    public static void main(String[] args) {
        System.out.println("=== 蔡晟旭的 Assignment 1: Stack 測試 ===");
        CustomStack<Integer> myStack = new CustomStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.pop();
        myStack.pop();

        System.out.println("\n=== 蔡晟旭的 Assignment 1: Queue 測試 ===");
        CustomQueue<String> myQueue = new CustomQueue<>();
        myQueue.enqueue("A");
        myQueue.enqueue("B");
        myQueue.enqueue("C");
        myQueue.peek();
        myQueue.dequeue();
        myQueue.dequeue();
        
        System.out.println("\n程式執行完畢，請截圖終端機畫面！");
    }
}