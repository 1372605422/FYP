/**

A class to calculate the value of options in the output sheet of a financial model.
This class provides methods to set and get the value of options, based on input parameters
in the financial model's output sheet.
The value of options is calculated based on whether there are options present, as indicated
by the boolean inputB33, and the value of the options themselves, as indicated by the
double OptionValueD27.
Example usage:
A30ValueOfOptions valueOfOptions = new A30ValueOfOptions();
valueOfOptions.setValueOfOptions(true, 1000.0);
double optionsValue = valueOfOptions.getValueOfOptions();
*/
package com.back.example.OutputSheet;

public class A30ValueOfOptions {
    double valueOfOptions;

    public double getValueOfOptions() {
        return valueOfOptions;
    }

    public void setValueOfOptions(boolean inputB33, double OptionValueD27) {
        if (inputB33) {
            this.valueOfOptions = OptionValueD27;
        } else {
            this.valueOfOptions = 0;
        }

    }
}
