import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] array = {9, 4, 1, -3, 4, 7, 2, 6};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            // 层层比对把小的数往左移动
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                }
            }
        }
    }
}
