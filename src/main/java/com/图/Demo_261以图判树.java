package com.图;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/24 15:16
 */
class NewUF {
    int count;
    int[] parent;
    int[] size;

    public NewUF(int count) {
        this.count = count;
        parent = new int[count];
        size = new int[count];
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void union(int a, int b) {
        int aa = findParent(a);
        int bb = findParent(b);
        if (aa == bb) return;
        if (size[aa] > size[bb]) {
            parent[bb] = aa;
            size[aa] += size[bb];
        } else {
            parent[aa] = bb;
            size[bb] += size[aa];
        }
        count--;
    }

    public int getSize(int a) {
        return size[a];
    }

    public int getCount() {
        return count;
    }

    public boolean isConnect(int a, int b) {
        return findParent(a) == findParent(b);
    }

    public int findParent(int a) {
        if (parent[a] != a) {
            parent[a] = findParent(parent[a]);
        }
        return parent[a];
    }
}

public class Demo_261以图判树 {
    public static void main(String[] args) {

    }

    public boolean validTree(int n, int[][] edges) {
        NewUF newUF = new NewUF(n);
        for (int[] edge : edges) {
            if (newUF.isConnect(edge[0], edge[1])) {
                return false;
            }
            newUF.union(edge[0], edge[1]);
        }
        return newUF.getCount() == 1;
    }
}
