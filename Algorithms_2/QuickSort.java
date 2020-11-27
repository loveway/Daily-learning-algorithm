import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {2, 5, 6, 9, 4, 1, 3, 2};
        quickSort(array, 0 , array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) return;
        int pivotIndex = partition(array, startIndex, endIndex);
        quickSort(array, startIndex, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, endIndex);
    }

    public static int partition(int[] array, int startIndex, int endIndex) {
        int pivot = array[startIndex];
        int left = startIndex, right = endIndex;
        while (left != right) {
            // 如果右边指针指向位置大于基准数 pivot，则右指针 right 向左移动一位（因为右边的数就是要大于 pivot，所以不用动）
            while (left < right && array[right] > pivot) {
                right--;
            }
            // 出了上面 while 循环来到这里，说明此时 array[right] <= pivot，这时候右边指针 right 停下来，左边指针走，准备做交换
            // 下面如果左边指针指向位置 <= 基准数 pivot，则左指针 left 向右移动一位（因为左边的数就是要小于 pivot，所以不用动）
            while (left < right && array[left] <= pivot) {
                left++;
            }
            // 代码执行到这里，说明如果 left < right， 此时肯定是 (array[right] < pivot && array[left] > pivot)，进行左右值互换
            if (left < right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
            }
        }
        // 走到这里说明 left 和 right 相遇了，此时需要将基准数移到指针位置
        int p = array[left];
        array[left] = array[startIndex];
        array[startIndex] = p;
        // 交换完毕说明此时，基准数 pivot 左边都是小于 pivot 的，右边都是大于 pivot 的（但是不一定有序，
        // 所以还需要重新选定基准数，分别对左右两个数组进行下一轮排序）
        return left;
    }

}
