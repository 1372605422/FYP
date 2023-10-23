/**

The A40ROIC class represents the return on invested capital for a company over a period of time.

It accepts multiple input parameters such as boolean values, doubles, and objects of A12CostOfCapital and A39InvestedCapital classes, to calculate

the return on invested capital for each year over a specified period of time. The class provides a setter method to calculate the return on invested

capital for each year and store it in an ArrayList, and a getter method to retrieve the ArrayList of return on invested capital values and the terminal

return on invested capital value.
*/
package com.back.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class A40ROIC {

    public ArrayList<Double> roicList=new ArrayList<>();


    public double terminaLROIC;

    public void setTerminaLROIC(boolean inputB44,double inputB45,A12CostOfCapital costOfCapital) {
        if (inputB44){
            terminaLROIC=inputB45;
        }else {
            terminaLROIC=costOfCapital.getTerminalostOfCapital();
        }
    }

    public void setRoicList(A7EBIT1t ebit1t, A39InvestedCapital investedCapital,int yearOfList){
        for (int i = 0; i <=yearOfList; i++) {

            BigDecimal getEBIT1tListi= new BigDecimal(Double.toString(ebit1t.getEBIT1tList().get(i)));
            BigDecimal investedCapitalListi=new BigDecimal(Double.toString(investedCapital.investedCapitalList.get(i)));
            BigDecimal ans= getEBIT1tListi.divide(investedCapitalListi,20, RoundingMode.HALF_UP);

            double temp=ans.setScale(4, RoundingMode.HALF_UP).doubleValue();
            //double temp=ebit1t.getEBIT1tList().get(i)/investedCapital.investedCapitalList.get(i);
            roicList.add(temp);
        }
        roicList.add(terminaLROIC);

    }



    public ArrayList<Double> getRoicList(){
        return roicList;
    }
    public double getTerminaLROIC() {
        return terminaLROIC;
    }


}

