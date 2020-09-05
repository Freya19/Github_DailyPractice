package freya19.practice.笔试;

/**sougou -2 ：贴着已有房子的一边建房子*/
public class 区间_建房子 {
    public int getHouses(int t, int[] xa) {
        // write code here
        int sum = 0;
        for (int i = 0; i < xa.length / 2 - 1; i++) {
            float r = xa[2 * i] + xa[2 * i + 1] / 2f;
            float l = xa[2 * i + 2] - xa[2 * i + 3] / 2f;
            if (l - r > t) {
                sum += 2;
            } else if (l - r == t) {
                sum += 1;
            }
        }

        return sum += 2;
    }
}
