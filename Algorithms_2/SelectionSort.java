import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = {2, 3, 7, 9, 1, 5, 4, 3};
        selectionSort(array);
        System.out.println(Arrays.toString(array));// {1, 2, 3, 3, 4, 5, 7, 9}
    }
    // 选择排序，会改变相同元素的位置，是一种不稳定排序，时间复杂度 O(n^2)，空间复杂度 O(1)
    public static void selectionSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            // 先让最小的 index 为每一轮的第一个
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                // 往后面循环的过程中，逐一比较，找出最小的 index，并且赋值给 minIndex
                minIndex = array[minIndex] < array[j] ? minIndex : j;
            }
            // 第一轮循环完毕，把找出来的最小数放在每一轮的第一个
            int tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }
    }

}
