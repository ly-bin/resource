/**
 * @author qb
 * @description: 主要考察两个有序数组的合并
 * @date 2017-2-14 11:49
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int [] n1 = {1,3,5,7,8};
        int [] n2 = {2,4,6,9,10};
        System.out.println(findMedianSortedArrays(n1,n2));
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2){
	// 检查nums1和nums2是否为有序数组的工作在此处略去
        double median = 0;
        int index1 = 0,index2 = 0,index3 = 0;
        int len = nums1.length + nums2.length;
        int newArray[] = new int[len];
        while(index1 < nums1.length && index2 < nums2.length){
            if(nums1[index1] < nums2[index2]){
                newArray[index3++] = nums1[index1++];
            }else {
                newArray[index3++] = nums2[index2++];
            }
        }
        while (index1 < nums1.length){
            newArray[index3++] = nums1[index1++];
        }
        while (index2 < nums2.length){
            newArray[index3++] = nums2[index2++];
        }

        if(len % 2 == 0){
            median = (newArray[len / 2 - 1] + newArray[len / 2]) * 1.0 / 2;
        }else {
            median = newArray[len / 2];
        }
        return median;
    }
}
