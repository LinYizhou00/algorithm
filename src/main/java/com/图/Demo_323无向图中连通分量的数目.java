package com.图;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/22 9:03
 */
class UF {
    int count;
    int[] parent;

    public UF(int count) {
        this.count = count;
        this.parent = new int[count];
        for (int i = 0; i < count; i++) {
            this.parent[i] = i;
        }
    }

    public void union(int a, int b) {
        int aa = find(a);
        int bb = find(b);
        if (aa == bb) {
            return;
        }
        parent[aa] = bb;
        count--;
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean isConnect(int a, int b) {
        return find(a) == find(b);
    }
}

public class Demo_323无向图中连通分量的数目 {
    public static void main(String[] args) {

    }

    public int countComponents(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.count;

    }

}
