/**

The A31ValueOfEquityInCommonStock class represents the value of equity in common stock for a company.

It calculates the value of equity in common stock based on the following formula:

Value of Equity in Common Stock = Value of Equity - Value of Options

The class accepts two input parameters, A29ValueOfEquity and A30ValueOfOptions, to calculate the value of equity

in common stock. The class also provides a getter method to retrieve the calculated value of equity in common stock.
*/
package com.back.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class A31ValueOfEquityInCommonStock {
    double valueOfEquityInCommonStock;

    public double getValueOfEquityInCommonStock() {
        return valueOfEquityInCommonStock;
    }

    public void setValueOfEquityInCommonStock(A29ValueOfEquity valueOfEquity, A30ValueOfOptions valueOfOptions) {
        BigDecimal getValueOfEquity = new BigDecimal(Double.toString(valueOfEquity.getValueOfEquity()));
        BigDecimal getValueOfOptions = new BigDecimal(Double.toString(valueOfOptions.getValueOfOptions()));
        BigDecimal ans=getValueOfEquity.subtract(getValueOfOptions);
        double temp=ans.setScale(4, RoundingMode.HALF_UP).doubleValue();


        valueOfEquityInCommonStock=temp;
        //valueOfEquityInCommonStock = valueOfEquity.getValueOfEquity() - valueOfOptions.getValueOfOptions();
    }

}
