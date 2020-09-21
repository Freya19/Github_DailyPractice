package gepeng18.考试;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 字符串匹配 {
    /** 使用 Pattern 预编译功能 */
    private static Pattern PUBLIC_CLASS_PATTERN = Pattern.compile("(ab*c)");

    public static String matchPublicClassName(String source){
        // 从源码字符串中匹配类名
        Matcher matcher = PUBLIC_CLASS_PATTERN.matcher(source);
        String className;
        if (matcher.find()) {
            className = matcher.group(1);
        } else {
            throw new IllegalArgumentException("No valid class");
        }
        return className;
    }
}
