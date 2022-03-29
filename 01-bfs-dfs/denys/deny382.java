package com.company;

import java.util.Scanner;


public class Maze {
    static int n;

    static public void dbs(int[][] mas, int i, int j){

        int k=0;
        if(mas[i-1][j]==-1) k++;
        if(mas[i+1][j]==-1) k++;
        if(mas[i][j-1]==-1) k++;
        if(mas[i][j+1]==-1) k++;

        mas[i][j]=k;

        if(mas[i-1][j]==-3) dbs(mas,i-1,j);
        if(mas[i+1][j]==-3) dbs(mas,i+1,j);
        if(mas[i][j-1]==-3) dbs(mas,i,j-1);
        if(mas[i][j+1]==-3) dbs(mas,i,j+1);
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n=in.nextInt();

        int[][] mas = new int[n+2][n+2];

        for (int i = 0; i < n+2; i++) {
            mas[0][i]=-1;
            mas[i][0]=-1;
            mas[i][n+1]=-1;
            mas[n+1][i]=-1;
        }

//        mas[0][0]=-2; mas[0][1]=-2; mas[1][0]=-2;
//        mas[n+1][n+1]=-2;mas[n+1][n]=-2;mas[n][n+1]=-2;



        for (int i = 1; i <n+1 ; i++) {
            String a = in.next();
            for (int j = 1; j <n+1; j++){
                char c=a.charAt(j-1);
                if(c=='#') mas[i][j]=-1;
                else mas[i][j]=-3;
            }
        }

        dbs(mas,1,1);
        if(mas[n][n]<0) dbs(mas,n,n);

        int sum=0;
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j <n+1; j++) {
                if(mas[i][j]>0) sum+=mas[i][j];
            }
        }

//        for (int i = 0; i < n+2; i++) {
//            for (int j = 0; j < n+2; j++) {
//                System.out.print(mas[i][j]+" ");
//            }
//            System.out.println("");
//        }

        System.out.println((sum-4)*25);

    }
}
