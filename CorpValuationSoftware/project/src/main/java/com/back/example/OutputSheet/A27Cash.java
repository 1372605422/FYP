/**

This class stores the amount of cash and provides methods to set and get the value of cash.
This class has the following public methods:
setCash(boolean inputB63, double inputB15, double inputB64, double inputB65, double inputB21)
This method takes in a boolean value which represents if none of the cash is trapped (in foreign countries)
and that there is no additional tax liability coming due and that cash is a neutral asset,
a double value which represents the book value of cash, a double value which represents the trapped cash (if taxes)
or entire balance (if mistrust), a double value which represents the average tax rate of the foreign markets where
the cash is trapped, and a double value which represents the sum of the present value of cash flows over 10 years
and the present value of the terminal value. If none of the cash is trapped, the method sets the inputB15 as
the value of cash. Otherwise, the method calculates the amount of cash that is not trapped by subtracting
the product of inputB64 and the difference between inputB21 and inputB65 from the inputB15.
getCash()
This method returns the value of cash stored in the cash variable.
*/
package com.back.example.OutputSheet;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class A27Cash {

    double cash;

    public double getCash() {
        return cash;
    }

    //B63 = if none of the cash is trapped (in foreign countries) and that there is no additional tax liability coming due and that cash is a neutral asset.
    //B64 = trapped cash (if taxes) or entire balance (if mistrust)
    //B65 = Average tax rate of the foreign markets where the cash is trapped
    public void setCash(boolean inputB63, double inputB15, double inputB64, double inputB65, double inputB21) {
        if (inputB63) {
            BigDecimal big_B15 = new BigDecimal(Double.toString(inputB15));
            BigDecimal big_B64 = new BigDecimal(Double.toString(inputB64));
            BigDecimal big_B21 = new BigDecimal(Double.toString(inputB21));
            BigDecimal big_B65 = new BigDecimal(Double.toString(inputB65));
            BigDecimal ans1 = big_B21.subtract(big_B65);
            BigDecimal ans2 = big_B64.multiply(ans1);
            BigDecimal ans3 = big_B15.subtract(ans2);
            double temp=ans3.setScale(4, RoundingMode.HALF_UP).doubleValue();

            cash=temp;
            //cash = inputB15 - inputB64 * (inputB21 - inputB65);
        } else {
            cash = inputB15;
        }
    }

}
