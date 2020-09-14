package gepeng18.考试;

public class 路径 {

    public int compute(int w,int state,int [][] path,int src,int dst){
        int min = Integer.MAX_VALUE;
        for (int i = 0;i<w;i++){
            if(path[i][0] == src && path[i][1] == dst){
                int cur = state + path[i][2];
                min = Math.min(cur,min);
            }
            else if (path[i][0] == src){
                int cur =  compute(w,state+ path[i][2] ,path,path[i][1],dst);
                min = Math.min(cur,min);
            }
        }
        return min;
    }
}
