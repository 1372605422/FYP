
/**

This class stores the amount of non-operating assets and provides methods to set and get the value of non-operating assets.
This class has the following public methods:
setNonOperatingAssets(double inputB16)
This method takes in a double value which represents the book value of non-operating assets and sets the inputB16
as the value of non-operating assets.
getNonOperatingAssets()
This method returns the value of non-operating assets stored in the nonOperatingAssets variable.
*/
package com.back.example.OutputSheet;

public class A28NonOperatingAssets {
    double nonOperatingAssets;

    public double getNonOperatingAssets() {
        return nonOperatingAssets;
    }

    public void setNonOperatingAssets(double inputB16) {
        this.nonOperatingAssets = inputB16;
    }
}
