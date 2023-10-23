/**

The A33EstimatedValueShare class represents the estimated value of a single share of a company.

It calculates the estimated value of a single share based on the following formula:

Estimated Value per Share = Value of Equity in Common Stock / Number of Shares

The class accepts two input parameters, A32NumberOfShares and A31ValueOfEquityInCommonStock, to calculate the estimated value

of a single share. The class also provides a getter method to retrieve the calculated estimated value per share.
*/
package com.back.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class A33EstimatedValueShare {
    double estimatedValueShare;

    public double getEstimatedValueShare() {
        return estimatedValueShare;
    }

    public void setEstimatedValueShare(A32NumberOfShares numberOfShares, A31ValueOfEquityInCommonStock valueOfEquityInCommonStock) {
        BigDecimal InCommonStock = new BigDecimal(Double.toString(valueOfEquityInCommonStock.getValueOfEquityInCommonStock()));
        BigDecimal NumberOfShares = new BigDecimal(Double.toString(numberOfShares.getNumberOfShares()));
        BigDecimal ans=InCommonStock.divide(NumberOfShares,20,RoundingMode.HALF_UP);
        double temp=ans.setScale(4, RoundingMode.HALF_UP).doubleValue();

        estimatedValueShare=temp;
       // estimatedValueShare =  valueOfEquityInCommonStock.getValueOfEquityInCommonStock()/numberOfShares.getNumberOfShares() ;
    }
}
