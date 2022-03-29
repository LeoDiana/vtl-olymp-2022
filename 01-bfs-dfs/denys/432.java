package com.company;

import java.util.Scanner;


public class Main {
    static int n,m;

    static public void dbs(int[][] mas, int i, int j, int k){

        mas[i][j]=k;
        if(i>0 && mas[i-1][j]==-1) dbs(mas,i-1,j,k);
        if(i<n-1 && mas[i+1][j]==-1) dbs(mas,i+1,j,k);
        if(j>0 && mas[i][j-1]==-1) dbs(mas,i,j-1,k);
        if(j<m-1 && mas[i][j+1]==-1) dbs(mas,i,j+1,k);
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n=in.nextInt();
        m=in.nextInt();

        int[][] mas = new int[n][m];
        for (int i = 0; i <n ; i++) {
            String a = in.next();
            for (int j = 0; j <m; j++){
                char c=a.charAt(j);
                if(c=='#') mas[i][j]=-1;
                else mas[i][j]=0;
            }
        }

        int k=1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if(mas[i][j]==-1){
                    dbs(mas,i,j,k);
                    k++;
                }

            }
        }

        System.out.println(--k);

    }
}
