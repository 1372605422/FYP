/**

The A35PriceAsOfValue class represents the price of a single share of a company as a percentage of its estimated value.

It calculates the price of a single share as a percentage of its estimated value based on the following formula:

Price as a Percentage of Value = Price of a Single Share / Estimated Value per Share

The class accepts two input parameters, A34Price and A33EstimatedValueShare, to calculate the price of a single share

as a percentage of its estimated value. The class also provides a getter method to retrieve the calculated price as a percentage of value.
*/
package com.back.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class A35PriceAsOfValue {

    double priceAsPercentageOfValue;

    public double getPriceAsPercentageOfValue() {
        return priceAsPercentageOfValue;
    }

    public void setPriceAsPercentageOfValue(A34Price price, A33EstimatedValueShare estimatedValue) {
        BigDecimal Price = new BigDecimal(Double.toString(price.getPrice()));
        BigDecimal EstimatedValueShare = new BigDecimal(Double.toString(estimatedValue.getEstimatedValueShare()));
        BigDecimal ans=Price.divide(EstimatedValueShare,20, RoundingMode.HALF_UP);
        double temp=ans.setScale(4, RoundingMode.HALF_UP).doubleValue();

        priceAsPercentageOfValue=temp;
        //priceAsPercentageOfValue = price.getPrice()/ estimatedValue.getEstimatedValueShare();
    }

}
