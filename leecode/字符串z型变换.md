#### 1、字符串z型变换、
> 1、描述：https://leetcode-cn.com/problems/zigzag-conversion/

> 2、时间复杂度：O（n）,

> 3、空间复杂度：O（n),

> 4、思路：主要是找出z型字符串的规律

```
// 将第一行和最后一行单独做的时候执行时间会快一些，其实快一联合在一个循环里面的
public String convert(String s, int numRows) {
        if (s == null || s.length() < 3 || numRows < 2 || s.length() < numRows) {
            return s;
        }
        int len = s.length();
        int groupNum = (numRows << 1) - 2;
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i += groupNum) {
            sb.append(s.charAt(i));
        }
        for (int i = 1; i < numRows -1; i++) {
            for (int j = i; j < len; j += groupNum) {
                sb.append(s.charAt(j));
                int end = j + groupNum - 2*i;
                if (end > len - 1) {
                    break;
                }
                sb.append(s.charAt(end));
            }
        }
        for (int i = numRows - 1; i < len; i += groupNum) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
// 使用这个示例执行时间比上一个较慢
 public String convert(String s, int numRows) {
        if (s == null || s.length() < 3 || numRows < 2) {
            return s;
        }
        int len = s.length();
        int groupNum = (numRows << 1) - 2;
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < len; j += groupNum) {
                sb.append(s.charAt(j));
                int end = j + groupNum - 2*i;
                if (end == j || end == j + groupNum){
                    continue;
                }
                if (end > len - 1) {
                    break;
                }
                sb.append(s.charAt(end));
            }
        }
        return sb.toString();
    }
```

