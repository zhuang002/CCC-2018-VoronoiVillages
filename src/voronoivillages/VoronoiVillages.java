/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voronoivillages;

import java.util.Scanner;

/**
 *
 * @author zhuan
 */
public class VoronoiVillages {

    /**
     * @param args the command line arguments
     */
    static int[] villages=new int[100];
    static int noOfVillages=0;
    static double minSize=0;
    public static void main(String[] args) {
        // TODO code application logic here
        readInput();
        minSize=neighbourSize(1);
        for (int i=1;i<noOfVillages-1;i++) {
            double newSize=neighbourSize(i);
            if (minSize>newSize)
                minSize=newSize;
        }
        System.out.format("%.1f",minSize);
    }

    private static void readInput() {
        Scanner sc=new Scanner(System.in);
        noOfVillages = sc.nextInt();

        for (int i=0;i<noOfVillages;i++) {
            int position=sc.nextInt();
            addVillage(i,position);
        }
    }

    private static double neighbourSize(int i) {
        return (((double)villages[i+1]-(double)villages[i-1])/2);
    }

    private static void addVillage(int total, int position) {
        if (total==0) {
            villages[total]=position;
            return;
        }
        for (int i=0;i<total;i++) {
            if (position<villages[i]) {
                insertVillage(i,position,total);
                return;
            }
        }
    }

    private static void insertVillage(int index,int position, int total) {
        for (int i=total;i>index;i--) {
            villages[i]=villages[i-1];
        }
        villages[index]=position;
    }
}
