/**

The A32NumberOfShares class represents the number of shares of a company.

It accepts a single input parameter, which is the number of shares, and sets it as the number of shares for the company.

The class also provides a getter method to retrieve the number of shares.
*/
package com.back.example.OutputSheet;

public class A32NumberOfShares {
    double numberOfShares;

    public double getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(double inputB18) {
        this.numberOfShares = inputB18;
    }
}
