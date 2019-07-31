package com.TwoPointer;

public class Out {
    public static void main(String[]args){
        Out test= new Out();
        test.go();
    }

    public void go(){
        int y=7;
        for(int x=1;x<8;x++){
            y++;
            if(x>4){
                System.out.print(++y +"");
            }
            if(y>14){
                System.out.print("x=" +x);
                break;
            }
        }
    }
}
