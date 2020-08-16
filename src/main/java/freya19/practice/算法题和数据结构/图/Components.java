package freya19.practice.算法题和数据结构.图;

/**
 * 求无权图的联通分量
 */
public class Components {

    /** 图的引用 */
    IGraph iGraph;

    /** 记录dfs的过程中节点是否被访问 */
    private boolean[] visited;

    /** 记录联通分量个数 */
    private int ccount;

    /** 每个节点所对应的联通分量标记 */
    private int[] id;

    /** 构造函数, 求出无权图的联通分量 */
    public Components(IGraph graph){

        // 算法初始化
        iGraph = graph;
        visited = new boolean[iGraph.V()];
        id = new int[iGraph.V()];
        ccount = 0;
        for(int i = 0; i < iGraph.V() ; i ++ ){
            visited[i] = false;
            id[i] = -1;
        }

        // 求图的联通分量
        for(int i = 0; i < iGraph.V() ; i ++ ) {
            if( !visited[i] ){
                dfs(i);
                ccount ++;
            }
        }
    }

    /** 图的深度优先遍历 */
    void dfs( int v ){

        visited[v] = true;
        id[v] = ccount;

        for( int i: iGraph.adj(v) ){
            if( !visited[i] ) {
                dfs(i);
            }
        }
    }

    // 返回图的联通分量个数
    int count(){
        return ccount;
    }

    // 查询点v和点w是否联通
    boolean isConnected( int v , int w ){
        assert v >= 0 && v < iGraph.V();
        assert w >= 0 && w < iGraph.V();
        return id[v] == id[w];
    }
}

