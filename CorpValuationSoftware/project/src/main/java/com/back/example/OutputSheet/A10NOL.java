/**

This class calculates the net operating loss (NOL) for each year.
It takes into account whether there was a carryforward of NOL from previous years and the EBIT income for each year.
The result is stored in an ArrayList called nolList.
*/
package com.back.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class A10NOL {
    ArrayList<Double> nolList=new ArrayList<>();


    public void setNolList(boolean B54,double B55,A5EBITIncome ebitIncome,int yearOfList) {
        if(B54){
            nolList.add(B55);
        }
        else{
            nolList.add((double) 0);
        }

        for (int i = 1; i <=1+yearOfList; i++) {
            BigDecimal nolListget1 =new BigDecimal(Double.toString(nolList.get(i-1)));
            BigDecimal getEBITIncomeListi=new BigDecimal(Double.toString(ebitIncome.getEBITIncomeList().get(i)));
            BigDecimal ans=nolListget1.subtract(getEBITIncomeListi);
            double temp= ans.setScale(4, RoundingMode.HALF_UP).doubleValue();


            if(ebitIncome.getEBITIncomeList().get(i)<0){

                nolList.add(temp);
                //nolList.add(nolList.get(i-1)-ebitIncome.getEBITIncomeList().get(i));
            }
            else{
                if(nolList.get(i-1)>ebitIncome.getEBITIncomeList().get(i)){
                    nolList.add(temp);
                    //nolList.add(nolList.get(i-1)-ebitIncome.getEBITIncomeList().get(i));
                }
                else {
                    nolList.add((double) 0);
                }
            }
        }

    }

    public ArrayList<Double> getNolList() {
        return nolList;
    }

}
