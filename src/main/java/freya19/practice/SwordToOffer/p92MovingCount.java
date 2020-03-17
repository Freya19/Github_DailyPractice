//package freya19.practice.SwordToOffer;
///*
//地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能
//向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和
//大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
//但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
//
//时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M
// */
//import java.lang.reflect.Array;
//
//public class p92MovingCount {
//    //四周移动的范围
//    private int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
//    // 整个方格的行列数
//    private int m,n;
//
//    private int count;
//    //是否符合可入方格
//    private boolean[][] visited;
//    //是否越界
//    private boolean inArea(int x, int y){
//        return (x >= 0 && x < m && y >= 0 && y < n);
//    }
//
//    public int movingCount(int threshold, int rows, int cols) {
//        if(threshold<0||rows<=0||cols<=0) return 0;
//        visited = new boolean[rows][cols];// 默认填充的是false
//
//        count = movingCountCore(threshold,rows, cols, 0, 0, visited);
//        return count;
//    }
//
//    public int movingCountCore(int threshold, int rows, int cols, int movex,int movey, boolean[][] visited){
//        count = 0;
//        if(threshold==0&&rows==0&&cols==0)
//            return 0;
//        m=rows;
//        n=cols;
//
//        if(!visited[movex][movey])
//
//
//        return count;
//    }
//}
