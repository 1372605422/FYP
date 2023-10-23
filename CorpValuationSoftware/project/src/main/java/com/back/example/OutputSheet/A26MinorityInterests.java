/**

This class stores the amount of minority interests and provides methods to set and get the value of minority interests.
This class has the following public methods:
setMinorityInterests(double inputB17)
This method takes in a double value which represents the book value of minority interests and sets it as
the value of minority interests.
getMinorityInterests()
This method returns the value of minority interests stored in the minorityInterests variable.
*/
package com.back.example.OutputSheet;

public class A26MinorityInterests {
    double minorityInterests;

    public double getMinorityInterests() {
        return minorityInterests;
    }

    public void setMinorityInterests(double inputB17) {
        this.minorityInterests = inputB17;
    }

}
