package freya19.practice.算法题和数据结构.图;

// 图的接口
public interface IGraph {

    int V();

    int E();

    void addEdge(int v, int w);

    boolean hasEdge(int v, int w);

    void show();

    Iterable<Integer> adj(int v);
}

