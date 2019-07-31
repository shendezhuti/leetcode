package com.Math;

public class SieveofEratosthenes {
    public static void main(String[]args){
    System.out.println(returnClosesizeEstimateNumber(100));
    }

    protected static int returnClosesizeEstimateNumber(int sizeEstimate){
        int n=2*sizeEstimate;
        int primeNumber=0;
        double smallest=1.0;
        boolean []prime= new boolean[n+1];
        for(int i=2;i<=n;i++){
            prime[i]=true; //prime until proven composite
        }

        for(int divisor=2;divisor*divisor<=n;divisor++){
            if(prime[divisor]){
                for(int i=2*divisor;i<=n;i=i+divisor){
                    prime[i]=false;
                }
            }
        }
//        for(int i=2;i<n;i++){
//            if(prime[i]){
//                System.out.println(i);
//            }
//        }
        for(int i=sizeEstimate;i<n;i++){
            if(prime[i]){
                double result=Math.abs(((double) sizeEstimate/i)-0.75);
                if(result<smallest){
                    primeNumber=i;
                    smallest=result;
                }
            }
        }
        return primeNumber;
    }

}
