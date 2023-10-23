/**

This class calculates the present value of the terminal value and stores it in a double variable.
The present value is calculated as the product of the terminal value obtained from A18TerminalValue class
and the cumulated discount factor at the 10th year, which is obtained from A13CumulatedDiscountFactor class.
This class has the following public methods:
setpVTerminalValue(A18TerminalValue terminalValue, A13CumulatedDiscountFactor cumulatedDiscountFactor)
This method takes in an object of A18TerminalValue class which contains the terminal value,
and an object of A13CumulatedDiscountFactor class which contains the cumulated discount factor list.
The method then calculates the present value of the terminal value and stores it in a double variable.
getpVTerminalValue()
This method returns the present value of the terminal value calculated by setpVTerminalValue() method.
*/
package com.back.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class A19PVTerminalValue {
    public double getpVTerminalValue() {
        return pVTerminalValue;
    }


    public void setpVTerminalValue(A18TerminalValue terminalValue, A13CumulatedDiscountFactor cumulatedDiscountFactor) {
        BigDecimal getTerminalvalue=new BigDecimal(Double.toString(terminalValue.getTerminalvalue()));
        BigDecimal getCumulatedDFList10=new BigDecimal(Double.toString(cumulatedDiscountFactor.getCumulatedDFList().get(10)));
        BigDecimal ans=getTerminalvalue.multiply(getCumulatedDFList10);
        double temp=ans.setScale(4, RoundingMode.HALF_UP).doubleValue();

       this.pVTerminalValue=temp;
        //this.pVTerminalValue = terminalValue.getTerminalvalue() * cumulatedDiscountFactor.getCumulatedDFList().get(10);

    }

    double pVTerminalValue;


}
