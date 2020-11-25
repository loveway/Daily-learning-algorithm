
class Bubble {
    public static void main(String[] args) {
        // 定义10个数据的数组
        int[] data = {5, 3, 4, 6, 7, 1, 2};

        bubbleSort(data);
        // 打印排序后的数组数据
        for (int datum : data) {
            System.out.println(datum);
        }
    }

    /**
     * 冒泡排序：每次比较从第一个数据开始，数据两两比较，如果左边数据比右边数据大，则交换左右数据。继续比较。一次比较结束出现一个最大值在最后一个位置。
     * 
     * @param data
     */
    private static void bubbleSort(int[] data) {

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                   int tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                }
            }
        }
    }
}
