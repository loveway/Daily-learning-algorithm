import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = {6, 2, 1, 4, 3, 34, 10, 7};
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
    // 归并排序是一种稳定排序，无论是在最好情况下还是在最坏情况下时间复杂度均是 O(nlogn)，控件复杂度是 O(n)
    // 递归
    public static void sort(int[] array, int left, int right) {
        int mid = (left + right) / 2;
        if (left < right) {
            sort(array, left, mid);
            sort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }
    // 合并
    public static void merge(int[] array, int left, int mid, int right) {
        // 新建临时数组，每次进来都得新建，所以空间复杂度是 O(n)
        int[] tmpArray = new int[array.length];
        // 定义左右起始、终止点
        int leftStart = left, leftEnd = mid, rightStart = mid + 1, rightEnd = right;
        // 定义 tmpArray 最开始的 index
        int pos = left;
        // 定义临时下标，后面将 tmpArray 复制到 array 时用
        int tmpStart = left;
        // 如果左右指针没有相遇就继续循环
        while (leftStart <= leftEnd && rightStart <= rightEnd) {
            // 从租左右两个数组中取出最小的放进 tmpArray
            if (array[leftStart] <= array[rightStart]) {
                tmpArray[pos++] = array[leftStart++];
            } else {
                tmpArray[pos++] = array[rightStart++];
            }
        }
        // 左右两个数组长度不一时会有剩余，将剩余的数放进 tmpArray（下面两个 while 循环只会走一个）
        while (leftStart <= leftEnd) {
            tmpArray[pos++] = array[leftStart++];
        }
        while (rightStart <= rightEnd) {
            tmpArray[pos++] = array[rightStart++];
        }
        // 将 tmpArray copy 到 array，此时 array 就已经排序好了
        while (tmpStart <= right) {
            array[tmpStart] = tmpArray[tmpStart++];
        }
    }
}
