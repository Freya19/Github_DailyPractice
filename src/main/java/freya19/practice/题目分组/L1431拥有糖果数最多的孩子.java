package freya19.practice.题目分组;

import java.util.ArrayList;
import java.util.List;

public class L1431拥有糖果数最多的孩子 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        ArrayList<Boolean> resList = new ArrayList<>();

        int maxCandies=candies[0];
        for(int candy:candies){
            maxCandies=Math.max(maxCandies,candy);
        }

        for(int candy:candies){
            if(candy+extraCandies>=maxCandies){
                resList.add(true);
            } else {
                resList.add(false);
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        int[] candies = {12,1,12};
        int extra = 10;
        List<Boolean> list = new L1431拥有糖果数最多的孩子().kidsWithCandies(candies, extra);
        System.out.println(list);
    }
}
