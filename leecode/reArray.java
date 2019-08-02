/**
 * @author：qts
 * @description: 原整形数组a,目标数组b,将a数组中的元素从0开始依次添加到b数组，没添加一个元素，将b数组中的元素取反，直至a中的元素全部添加到b中，返回b数组
 * @date：2019/8/1 13:31
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        int[] result = new Test().test1(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

    }

    private int[] test1(int[] arry){
        int len = arry.length;
        int[] re = new int[len];
        for (int i = 0;i < len;i++){
            int index = index(len,i);
            re[index] = arry[i];
        }
        return re;
    }

    private int index(int len, int i) {
        int index = 0;
        int num = len - i;
        if (num % 2 == 0){
            index = (len - num / 2);
        }else {
            index = num / 2;
        }
        return index;
    }
}
