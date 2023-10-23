/**
 The A7EBIT1t class sets and retrieves the EBIT for each year after tax and NOLs.
 This class contains the following public methods:
 setTerminalEBIT1t: sets the terminal EBIT after tax and NOLs based on the input values.
 setEBIT1tList: sets the EBIT after tax and NOLs list based on the input values.
 getEBIT1tList: retrieves the EBIT after tax and NOLs list.
 getTerminalEBIT1t: retrieves the terminal EBIT after tax and NOLs.
 The following instance variables are used in this class:
 ebit1tList: an ArrayList of doubles that stores the EBIT after tax and NOLs.
 terminalEBIT1t: a double that stores the terminal EBIT after tax and NOLs.
 Note: The EBIT after tax and NOLs for each year is calculated based on the EBIT income, tax rate, and NOL for that year.
 The terminal EBIT after tax and NOLs is calculated based on the terminal EBIT income, tax rate, and NOL.
 package com.back.example.OutputSheet;
 @author [KeYi LIU]
 @version [V1.1]
 */
package com.back.example.OutputSheet;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class A7EBIT1t {
    public ArrayList<Double> ebit1tList = new ArrayList<>();
    public double terminalEBIT1t;



    public void setTerminalEBIT1t(double B20, A3Revenues revenues, A4EBITMargin ebitMargin) {
        BigDecimal big_1=new BigDecimal("1");
        BigDecimal big_B20=new BigDecimal(Double.toString(B20));
        BigDecimal getTerminalRevenues=new BigDecimal(Double.toString(revenues.getTerminalRevenues()));
        BigDecimal getTerminalEBITMargin=new BigDecimal(Double.toString(ebitMargin.getTerminalEBITMargin()));

        BigDecimal ans1=big_1.subtract(big_B20);
        BigDecimal ans2=ans1.multiply(getTerminalRevenues);
        BigDecimal ans3 =ans2.multiply(getTerminalEBITMargin);

        terminalEBIT1t=ans3.setScale(4, RoundingMode.HALF_UP).doubleValue();;
        //terminalEBIT1t = (1 - B20) * revenues.getTerminalRevenues() * ebitMargin.getTerminalEBITMargin();
    }


    public void setEBIT1tList(A5EBITIncome ebitIncome, double B20,A10NOL nol,int yearOfList) {
        BigDecimal big_1=new BigDecimal("1");
        BigDecimal big_B20=new BigDecimal(Double.toString(B20));
        BigDecimal EBITIncomeListget0=new BigDecimal(Double.toString(ebitIncome.getEBITIncomeList().get(0)));



        if (ebitIncome.getEBITIncomeList().get(0) > 0) {
            BigDecimal ans1=big_1.subtract(big_B20);
            BigDecimal ans2=ans1.multiply(EBITIncomeListget0);
            ebit1tList.add(ans2.setScale(4, RoundingMode.HALF_UP).doubleValue());

            //ebit1tList.add(ebitIncome.getEBITIncomeList().get(0) * (1 - B20));
        } else {
            ebit1tList.add(EBITIncomeListget0.setScale(4, RoundingMode.HALF_UP).doubleValue());
            //ebit1tList.add(ebitIncome.getEBITIncomeList().get(0));
        }


        for (int i = 1; i <=yearOfList ; i++) {

            BigDecimal EBITIncomeListgeti=new BigDecimal(Double.toString(ebitIncome.getEBITIncomeList().get(i)));
            BigDecimal NolListgeti1=new BigDecimal(Double.toString(nol.getNolList().get(i-1)));

            if(ebitIncome.getEBITIncomeList().get(i)>0){
                if(ebitIncome.getEBITIncomeList().get(i)<nol.getNolList().get(i-1)){
                    ebit1tList.add(ebitIncome.getEBITIncomeList().get(i));
                }
                else {

                    //ebit1tList.add((double)0);
                    BigDecimal ans1=EBITIncomeListgeti.subtract(NolListgeti1);
                    BigDecimal ans2=ans1.multiply(big_B20);
                    BigDecimal ans3=EBITIncomeListgeti.subtract(ans2);
                    ebit1tList.add(ans3.setScale(4, RoundingMode.HALF_UP).doubleValue());
                    //ebit1tList.add ( ebitIncome.getEBITIncomeList().get(i)-((ebitIncome.getEBITIncomeList().get(i)-nol.getNolList().get(i-1))*B20));
                }

            }
            else{
                    ebit1tList.add(ebitIncome.getEBITIncomeList().get(i));
            }
        }




        ebit1tList.add(terminalEBIT1t);
    }

    public ArrayList<Double> getEBIT1tList() {
        return ebit1tList;
    }

    public double getTerminalEBIT1t() {
        return terminalEBIT1t;
    }
}
