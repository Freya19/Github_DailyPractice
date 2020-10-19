package gepeng18.面试;

public class Exam {
    /**
     * 验证IP地址
     *
     * @param IP string字符串 一个IP地址字符串
     * @return string字符串
     */
    public static String solve(String IP) {
        // 假定为ipv4
        if (IP.split("\\.").length > 1) {

            String[] strs = IP.split("\\.");
            int[] nums = new int[strs.length];
            if (strs.length != 4) {
                return "Neither";
            }

            for (int i = 0; i < strs.length; i++) {
                nums[i] = Integer.valueOf(strs[i]);
                if (String.valueOf(Integer.valueOf(nums[i])).length() != strs[i].length())
                    return "Neither";
                if (nums[i] > 255)
                    return "Neither";
            }
            return "IPv4";
        } else {
            // 假定为ipv6
            String[] strs = IP.split(":");
            if (strs.length != 8) {
                return "Neither";
            }
            for (int i = 0; i < strs.length; i++) {
                if (strs[i] == null || strs[i].length() == 0)
                    return "Neither";
                else if (strs[i].length() > 4)
                    return "Neither";
            }
            return "IPv6";
        }
    }

    public static void main(String[] args) {
        String s = solve("2001:0db8:85a3:0:0:8A2E:0370:7334");
        System.out.println(s);
    }
}
