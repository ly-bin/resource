/**
 * @author qb
 * @description: 向后遍历数组，遇到重复值停止，比较最大长度（最小为1），
 *               下次从重复值的下个位置进行遍历，直到字符串遍历完毕。
 * @date 2017-2-9 17:28
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String str = "wrewrssdfetf";
        System.out.println(lengthOfLongestSubstring(str));
    }

    private static int lengthOfLongestSubstring(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        int start = 0;
        int maxLen = 1;
	    // 大小写字母的ASCII值
        boolean [] arr = new boolean[128];
        int len = s.length();
        for (int i = 0;i < len;i++){
            char c = s.charAt(i);
            if(arr[c]){
                maxLen = Math.max(maxLen,(i - start));
                for (int j = start;j < i;j++){
                    if(s.charAt(j) == c){
                        start = j + 1;
                        break;
                    }
                    arr[s.charAt(j)] = false;
                }
            }else {
                arr[c] = true;
            }
        }
        maxLen = Math.max(maxLen,len - start);
        return maxLen;
    }
}
