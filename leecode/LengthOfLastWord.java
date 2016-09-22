package leetcodemiddle;

import com.sun.jmx.snmp.Timestamp;
import com.sun.prism.paint.Stop;

import java.util.Date;

/**
 * @author
 * @version 1.0.0
 * @description:  方法2稍微快点，但是和已提交的代码速度还是有差距的
 * @date 2016-9-22 16:32
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "b   a    ";
        System.out.println(lengthOfLastWord1(s));
        System.out.println(lengthOfLastWord2(s));
    }

    private static int lengthOfLastWord1(String s) {
        String[] strArr = s.split(" ");
        System.out.println(strArr.length);
        if(strArr.length > 0){
            return strArr[strArr.length - 1].length();
        }
        return 0;
    }

    private static int lengthOfLastWord2(String s){
        String str = s.trim();
        if(str.length() == 0){
            return 0;
        }
        String [] strArr = str.split(" ");
        return strArr[strArr.length - 1].length();
    }
}
