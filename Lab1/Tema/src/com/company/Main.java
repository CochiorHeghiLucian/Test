package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Scrieti dimensiunea matricii: ");
        int n = keyboard.nextInt();
        System.out.println("Numarul citit: "+ n);
        int[][] square = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                square[i][j] = n * ((i + j + 1 + n / 2) % n) + (i + 2 * j + 1) % n + 1;
            }
        }

        if(n < 11) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(square[i][j] + " ");
                }
                System.out.println();
            }
        }

        System.out.println("Magic constant = "+verifyTheMagicConstant(n,square));



    }

    public static boolean verifyTheMagicConstant(int n, int[][] matrix){

        int sum,magicConstant = (n*(n*n+1))/2;
        System.out.println("MAGIC: "+ magicConstant);
        for(int i=0;i<n;i++){
            sum = 0;
            for(int j=0;j<n;j++){
                sum+= matrix[i][j];
            }
            if(sum != magicConstant){
                return false;
            }
        }
        for(int j=0;j<n;j++){
            sum = 0;
            for(int i=0;i<n;i++){
                sum+= matrix[i][j];
            }
            if(sum != magicConstant){
                return false;
            }
        }
        sum = 0;
        for(int i=0;i<n;i++){
            sum += matrix[i][i];
        }
        if(sum != magicConstant){
            return false;
        }
        sum = 0;
        for(int i=0;i<n;i++){
            sum += matrix[i][n-1-i];
        }
        if(sum != magicConstant){
            return false;
        }
        return true;
    }
}
