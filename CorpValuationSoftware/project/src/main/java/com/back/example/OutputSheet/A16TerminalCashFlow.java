/**

This class calculates the terminal cash flow and stores it in a double variable.
The terminal cash flow is calculated as the difference between the terminal year EBIT and
the terminal year reinvestment, both of which are obtained from A7EBIT1t and A8Reinvestment classes respectively.
This class has the following public methods:
setTerminalCashFlow(A7EBIT1t ebit1t, A8Reinvestment reinvestment)
This method takes in an object of A7EBIT1t class which contains the terminal year EBIT value,
and an object of A8Reinvestment class which contains the terminal year reinvestment value.
The method then calculates the terminal cash flow and stores it in a double variable.
getTerminalCashFlow()
This method returns the terminal cash flow value calculated by setTerminalCashFlow() method.
*/
package com.back.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class A16TerminalCashFlow {

    public double terminalCashFlow;


    public void setTerminalCashFlow(A7EBIT1t ebit1t, A8Reinvestment reinvestment) {
        BigDecimal getTerminalEBIT1t =new BigDecimal(Double.toString(ebit1t.getTerminalEBIT1t()));
        BigDecimal getTerminalreinvestment =new BigDecimal(Double.toString(reinvestment.getTerminalreinvestment()));
        BigDecimal ans= getTerminalEBIT1t.subtract(getTerminalreinvestment);

        terminalCashFlow= ans.setScale(4, RoundingMode.HALF_UP).doubleValue();
        //terminalCashFlow = ebit1t.getTerminalEBIT1t() - reinvestment.getTerminalreinvestment();
    }


    public double getTerminalCashFlow() {
        return terminalCashFlow;
    }


}
