package com.ArrayandString;

public class Fibonacci {
    private int count=0;
    private int[] result;
    public int Fibonaccirecursive(int n){

        if(n==1||n==2 ) return 1;
        else return Fibonaccirecursive(n-1)+Fibonaccirecursive(n-2);
    }


    public int FibonacciDPError(int n){
        int result=0;
        if(n==1||n==2)return 1;
        for(int i=0;i<n;i++){
            result =FibonacciDPError(i)+FibonacciDPError(i-1);
        }
        return result;
    }

    public int FibonacciDPCorrect(int n){
        int []result=new int [n+1];
        result[0]=result[1]=1;
        for(int i=2;i<n;i++){
            result[i] =result[i-1]+result[i-2];
        }
        return result[n-1];
    }

    public int Fibonaccirecursiveimprove(int n){
        if(this.count==0) {
            result = new int[n];
            this.count++;
        }

        if(result[n-1]>0) return result[n-1];
        else if(n<=2) return 1;
        else {
            int f=Fibonaccirecursiveimprove(n-1)+Fibonaccirecursiveimprove(n-2);
            result[n-1]=f;
            return f;
        }
    }

    public static void main (String []args){
        Fibonacci test=new Fibonacci();
        for(int i=1;i<=10;i++){
            int n=test.Fibonaccirecursive(i);
            System.out.println("递归法策略，当前天数为"+i+" 兔子数目为"+n);
        }


//        int n=12;
//        long sT1=System.nanoTime();
//        int n1=test.Fibonaccirecursive(n);
//        long eT1=System.nanoTime();
//        System.out.println("当前使用递归法 输入天数为"+n+" 兔子数目为"+n1+"");

//        long sT2=System.nanoTime();
//        int n2=test.FibonacciDPCorrect(n);
//        long eT2=System.nanoTime();
//        System.out.println("当前使用动态规划策略 输入天数为"+n+" 兔子数目为"+n2+" 所用时间为"+(eT2-sT2)+"ms");
//
//        long sT3=System.nanoTime();
//        int n3=test.Fibonaccirecursiveimprove(n);
//        long eT3=System.nanoTime();
//        System.out.println("当前使用递归法改善 输入天数为"+n+" 兔子数目为"+n3+" 所用时间为"+(eT3-sT3)+"ms");

    }
}
