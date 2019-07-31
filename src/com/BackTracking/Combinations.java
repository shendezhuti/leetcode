package com.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        backtrack(res,new ArrayList<>(),1,n,k);
        return res;
    }

    private void backtrack(List<List<Integer>>res,List<Integer>templist,int start,int n,int k){
        if(k==0){
            res.add(new ArrayList<>(templist));
            return ;
        }else{
            for(int i=start;i<=n;i++){
                templist.add(i);
                backtrack(res,templist,i+1,n,k-1);
                templist.remove(templist.size()-1);
            }
        }

    }
}
