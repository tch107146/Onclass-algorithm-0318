import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 國立澎湖科技大學 資訊工程學系
 * Author: 蔡晟旭 (Alexen)
 * Course: Algorithms
 * Assignment 1: Stack Sorting Process & Queue Operations with Time Complexity
 */
public class DataStructuresDemo {

    // 實作 Stack (符合 LIFO 原則)
    static class CustomStack {
        private ArrayList<Integer> elements = new ArrayList<>();
        
        // 時間複雜度: Amortized O(1)
        public void push(int item) { elements.add(item); }
        
        // 時間複雜度: O(1)
        public Integer pop() {
            if (isEmpty()) return null;
            return elements.remove(elements.size() - 1);
        }
        
        // 時間複雜度: O(1)
        public Integer peek() {
            if (isEmpty()) return null;
            return elements.get(elements.size() - 1);
        }
        
        public boolean isEmpty() { return elements.isEmpty(); }
        
        public String toString() { return elements.toString(); }
    }

    // 實作 Queue (符合 FIFO 原則)
    static class CustomQueue {
        private LinkedList<Integer> elements = new LinkedList<>();
        
        // 時間複雜度: O(1)
        public void enqueue(int item) { elements.addLast(item); }
        
        // 時間複雜度: O(1)
        public Integer dequeue() {
            if (isEmpty()) return null;
            return elements.removeFirst();
        }
        
        public boolean isEmpty() { return elements.isEmpty(); }
        
        public String toString() { return elements.toString(); }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomStack originalStack = new CustomStack();
        CustomQueue queue = new CustomQueue();

        // 1. 依照要求：請輸入數量
        System.out.print("請輸入數量：");
        int count = scanner.nextInt();

        // 2. 依照要求：請輸入數字
        System.out.print("請輸入數字 (請以空白隔開連續輸入)：");
        for (int i = 0; i < count; i++) {
            int num = scanner.nextInt();
            originalStack.push(num); // 放入 Stack
            queue.enqueue(num);      // 同時放入 Queue 以滿足作業要求
        }

        // 3. 輸出 STACK 的排序過程 (使用 temp)
        System.out.println("\n========== STACK 的排序過程 ==========");
        System.out.println("初始 Stack 狀態 (底 -> 頂)：" + originalStack.toString());
        
        CustomStack tempStack = new CustomStack();

        // --- 開始計算排序時間 ---
        long startTime = System.nanoTime();

        while (!originalStack.isEmpty()) {
            int temp = originalStack.pop();
            System.out.println("\n 取出了 (Pop)：" + temp + "，目前的 temp = " + temp);

            while (!tempStack.isEmpty() && tempStack.peek() > temp) {
                int moveBack = tempStack.pop();
                originalStack.push(moveBack);
                System.out.println("    發現 tempStack 頂端 (" + moveBack + ") > temp (" + temp + ")");
                System.out.println("    將 " + moveBack + " 退回原 Stack。目前原 Stack：" + originalStack.toString());
            }

            tempStack.push(temp);
            System.out.println("   將 temp (" + temp + ") 放入 tempStack。目前 tempStack：" + tempStack.toString());
        }

        // --- 結束計算排序時間 ---
        long endTime = System.nanoTime();
        long durationNano = endTime - startTime;
        double durationMs = durationNano / 1_000_000.0; // 轉換為毫秒

        System.out.println("\n Stack 排序完成！最終排序結果 (小到大，底 -> 頂)：" + tempStack.toString());
        System.out.printf("  [處理時間] Stack 排序實際花費時間：%.4f 毫秒 (ms)\n", durationMs);

        // 4. 輸出 QUEUE 的處理過程 (證明有整合 Queue)
        System.out.println("\n========== QUEUE 的處理過程 (FIFO) ==========");
        System.out.println("初始 Queue 狀態 (前 -> 後)：" + queue.toString());
        while (!queue.isEmpty()) {
            System.out.println(" 取出 (Dequeue)：" + queue.dequeue());
        }

        // 5. 輸出理論時間複雜度分析
        System.out.println("\n========== 理論時間複雜度分析 (Time Complexity) ==========");
        System.out.println(" Stack push/pop 操作：O(1) (使用 ArrayList 平攤成本)");
        System.out.println(" Queue enqueue/dequeue 操作：O(1)");
        System.out.println(" Stack 使用 temp 排序演算法：最差情況為 O(N^2)，N 為元素數量");

        System.out.println("\n程式執行完畢，請將上方終端機畫面截圖繳交！");
        scanner.close();
    }
}