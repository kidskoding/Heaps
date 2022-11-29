import java.util.*;
public class HeapMain {
    public static void main(String[] args) {
        int[] data = new int[]{3, 7, 4, 5, 2, 9, 8, 1, 6};
        List<TreeNode<Integer>> heap = new LinkedList<TreeNode<Integer>>();
        for(int i = 0; i < data.length; i++) {
            if(i == 0) {
                TreeNode<Integer> rootNode = new TreeNode<Integer>(data[i]);
                heap.add(rootNode);
            }
            else {
                int parentIndex = (i - 1) / 2;
                TreeNode<Integer> parentNode = heap.get(parentIndex);
                TreeNode<Integer> childNode = new TreeNode<Integer>(data[i], parentNode);
                heap.add(childNode);
            }
        }
        System.out.println(heap);
        return;
    }
    //Recursively
    static void siftDown(List<TreeNode<Integer>> heap, int index) {
        int LCI = index * 2 + 1;
        int RCI = index * 2 + 2;
        if(RCI < heap.size()) {
            int LCV = heap.get(LCI).getData();
            int RCV = heap.get(RCI).getData();
            int PV = heap.get(index).getData();
            if(RCV > LCV && RCV > PV) {
                swap(heap, LCV, RCV);
            }
            else if(LCI < heap.size()) {
                swap(heap, RCV, LCV);
            }
        }
        if(LCI < heap.size()) {
            int LCV = heap.get(LCI).getData();
            int RCV = heap.get(RCI).getData();
            int PV = heap.get(index).getData();
            if(RCV > LCV && RCV > PV) {
                swap(heap, LCV, RCV);
            }
            else if(LCI < heap.size()) {
                swap(heap, RCV, LCV);
            }
        }
        return;
    }

    static void swap(List<TreeNode<Integer>> heap, int i, int j) {
        int temp = heap.get(i).getData();
        heap.get(i).setData(heap.get(j).getData());
        heap.get(j).setData(temp);
        return;
    }

    //Call siftDown() on every index from last to first
    static void buildMaxHeap(List<TreeNode<Integer>> heap) {
        for(int i = heap.size() - 1; i >= 0; i--) {
            siftDown(heap, i);
        }
        return;
    }

    public static void heapSort(List<TreeNode<Integer>> heap) {

    }
}