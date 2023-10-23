/**

This class calculates the terminal value and stores it in a double variable.
The terminal value is calculated as the terminal cash flow divided by the difference between
the terminal cost of capital and the terminal revenue growth rate, both of which are obtained
from A12CostOfCapital and A2RevenueGrowthRate classes respectively.
This class has the following public methods:
setTerminalvalue(A12CostOfCapital costOfCapital, A16TerminalCashFlow terminalCashFlow, A2RevenueGrowthRate revenueGrowthRate)
This method takes in an object of A12CostOfCapital class which contains the terminal cost of capital value,
an object of A16TerminalCashFlow class which contains the terminal cash flow value,
and an object of A2RevenueGrowthRate class which contains the terminal revenue growth rate value.
The method then calculates the terminal value and stores it in a double variable.
getTerminalvalue()
This method returns the terminal value calculated by setTerminalvalue() method.
*/
package com.back.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class A18TerminalValue {

    public double terminalvalue;
    public void setTerminalvalue(A12CostOfCapital costOfCapital, A16TerminalCashFlow terminalCashFlow, A2RevenueGrowthRate revenueGrowthRate) {

        BigDecimal terminalostOfCapital =new BigDecimal(Double.toString(costOfCapital.terminalostOfCapital));
        BigDecimal getTerminalRevenueGrowthRate =new BigDecimal(Double.toString(revenueGrowthRate.getTerminalRevenueGrowthRate()));
        BigDecimal getTerminalCashFlow=new BigDecimal(Double.toString(terminalCashFlow.getTerminalCashFlow()));
        BigDecimal ans1=terminalostOfCapital.subtract(getTerminalRevenueGrowthRate);
        BigDecimal ans2=getTerminalCashFlow.divide(ans1,20, RoundingMode.HALF_UP);


        double temp=ans2.setScale(4, RoundingMode.HALF_UP).doubleValue();
        terminalvalue=temp;
        //terminalvalue = terminalCashFlow.getTerminalCashFlow() / (costOfCapital.terminalostOfCapital - revenueGrowthRate.getTerminalRevenueGrowthRate());

    }

    public double getTerminalvalue() {
        return terminalvalue;
    }


}
