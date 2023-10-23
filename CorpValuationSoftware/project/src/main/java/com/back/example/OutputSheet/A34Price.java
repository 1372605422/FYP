/**

The A34Price class represents the price of a single share of a company.

It accepts a single input parameter, which is the price of a single share, and sets it as the price for the company.

The class also provides a getter method to retrieve the price of a single share.
*/
package com.back.example.OutputSheet;

public class A34Price {
    double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double inputB19) {
        price = inputB19;
    }
}
