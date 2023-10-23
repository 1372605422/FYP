/**

The A38SalesToCapitalRatio class represents the sales to capital ratio for a company over a period of time.

It accepts a single input parameter, which is the sales to capital ratio for the first year, and creates an ArrayList

to store the sales to capital ratio for each subsequent year. The class provides a setter method to set the sales to capital

ratio for each year and a getter method to retrieve the ArrayList of sales to capital ratios.
*/
package com.back.example.OutputSheet;

import java.util.ArrayList;

public class A38SalesToCapitalRatio {

    public ArrayList <Double> salesToCapitalRatioList=new ArrayList<>();

    public void setSalesToCapitalRatioList(double inputB28,int yearOfList) {
        salesToCapitalRatioList.add((double) 0);
        for (int i = 1; i <=yearOfList ; i++) {
            salesToCapitalRatioList.add(inputB28);
        }
    }


    public ArrayList<Double> getSalesToCapitalRatioList() {
        return salesToCapitalRatioList;
    }
}
