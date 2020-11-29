import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {2, 3, 4, -1, 7, 5, 6};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
    // 快速排序
    public static void bubbleSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            // 快速排序的优化，做一个标记，如果某一次没有进入交换，则说明已经是有序的，后面的就不用再循环了
            boolean isSorted = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // 如果前一个比后一个大，就交换，大的向后移动
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    isSorted = false;
                }
            }
            if (isSorted) break;
        }
    }
}
