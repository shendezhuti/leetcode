package com.DFS;

public class UnionFindSet {
    private int[] parents_;
    private int[] ranks_;
    private int count=0;
    public UnionFindSet(int n) {
        count=n;
        parents_ = new int[n+1];
        ranks_ = new int[n+1];
        for (int i = 0; i < parents_.length; ++i) {
            parents_[i] = i;
            ranks_[i] = 1;
        }
    }

    public boolean Union(int u, int v) {
        int pu = Find(u);
        int pv = Find(v);
        if (pu == pv) return false;

        if (ranks_[pv] > ranks_[pu])
            parents_[pu] = pv;
        else if (ranks_[pu] > ranks_[pv])
            parents_[pv] = pu;
        else {
            parents_[pv] = pu;
            ranks_[pu] += 1;
        }
        count--;
        return true;
    }

    public int Find(int u) {
        while (parents_[u] != u) {
            parents_[u] = parents_[parents_[u]];//注意这里做了path compression
            u = parents_[u];
        }
        return u;
    }
    public int count(){
        return count;
    }
    public static void main(String[]args){
        int [][]edges={{0,1},{1,2},{1,3},{2,4},{3,4},{2,5}};
        UnionFindSet test=new UnionFindSet(edges.length);
        for (int i=0;i<edges.length;i++){
            int x=edges[i][0];
            int y=edges[i][1];
            if(!test.Union(x,y)) {
                System.out.print("cycle detected");
                break;
            }
        }
    }
}

