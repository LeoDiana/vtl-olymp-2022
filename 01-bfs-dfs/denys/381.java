package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
    static int n;
    static int xs,ys,xf,yf;
    static Queue <Integer> x;
    static Queue <Integer> y;
    static int[][] mas;

    public static void solve(){
        while(!x.isEmpty()){
            int i=x.poll();
            int j=y.poll();

            if(i>0 && mas[i-1][j]==0){
                mas[i-1][j]=mas[i][j]+1;
                x.add(i-1);
                y.add(j);
            }
            if(i<n-1 && mas[i+1][j]==0){
                mas[i+1][j]=mas[i][j]+1;
                x.add(i+1);
                y.add(j);
            }
            if(j>0 && mas[i][j-1]==0){
                mas[i][j-1]=mas[i][j]+1;
                x.add(i);
                y.add(j-1);
            }
            if(j<n-1 && mas[i][j+1]==0){
                mas[i][j+1]=mas[i][j]+1;
                x.add(i);
                y.add(j+1);
            }
        }
    }

    public static void dbs(int i, int j, int k){
        if(k>0) {
            mas[i][j] = -2;
            if (i > 0 && mas[i - 1][j] == k - 1) dbs(i - 1, j, k - 1);
            else if (i < n - 1 && mas[i + 1][j] == k - 1) dbs(i + 1, j, k - 1);
            else if (j > 0 && mas[i][j - 1] == k - 1) dbs(i, j - 1, k - 1);
            else if (j < n - 1 && mas[i][j + 1] == k - 1) dbs(i, j + 1, k - 1);
        }
    }

    public static char[][] result(){
        char[][] result = new char[n][n];
        for (int i = 0; i< n; i++) {
            for (int j = 0; j < n; j++) {
                if(mas[i][j]==-2) result[i][j]='+';
                else if(mas[i][j]==-1) result[i][j]='O';
                else result[i][j]='.';
            }
        }
        result[xs][ys]='@';
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n=in.nextInt();

        mas =new int[n][n];

        for (int i = 0; i <n ; i++) {
            String a = in.next();
            for (int j = 0; j <n; j++){
                char c=a.charAt(j);
                if(c=='O')mas[i][j]=-1;
                else mas[i][j]=0;

                if(c=='@') {xs=i; ys=j;}
                if(c=='X') {xf=i; yf=j;}
            }
        }
        x = new ArrayDeque<>();
        y = new ArrayDeque<>();

        x.add(xs);
        y.add(ys);
        solve();
        mas[xs][ys]=0;

        if(mas[xf][yf]!=0) {
            System.out.println("Yes");
            dbs(xf,yf,mas[xf][yf]);
            char[][] res = result();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(res[i][j]);
                }
                System.out.println("");
            }
        }else{
            System.out.println("No");
        }
    }
}
