/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voronoivillages;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author zhuan
 */
public class VoronoiVillages {

    /**
     * @param args the command line arguments
     */
    static int[] villages;
    public static void main(String[] args) {
        // TODO code application logic here
        readInput();
        double minSize=Double.MAX_VALUE;
        for (int i=1;i<villages.length-1;i++) {
            double newSize=neighbourSize(i);
            if (minSize>newSize)
                minSize=newSize;
        }
        System.out.printf("%.1f",minSize);
    }

    private static void readInput() {
        Scanner sc=new Scanner(System.in);
        int noOfVillages = sc.nextInt();
        villages=new int[noOfVillages];

        for (int i=0;i<noOfVillages;i++) {
            int position=sc.nextInt();
            villages[i]=position;
        }
        Arrays.sort(villages);
    }

    private static double neighbourSize(int i) {
        return (((double)villages[i+1]-(double)villages[i-1])/2);
    }
}
