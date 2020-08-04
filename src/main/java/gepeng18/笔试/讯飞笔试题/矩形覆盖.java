package gepeng18.笔试.讯飞笔试题;

public class 矩形覆盖 {
    // 两边必须同时覆盖才行
        public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
            // 边相交叫不覆盖，所以我们求不覆盖的场景时，边相交就可以考虑进去
            boolean x_overlap = !(rec1[2] <= rec2[0] || rec2[2] <= rec1[0]);
            boolean y_overlap = !(rec1[3] <= rec2[1] || rec2[3] <= rec1[1]);
            return x_overlap && y_overlap;
    }
}
