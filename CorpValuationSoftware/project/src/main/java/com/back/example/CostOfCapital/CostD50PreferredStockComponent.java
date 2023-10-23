package com.back.example.CostOfCapital;

public class CostD50PreferredStockComponent {
    private static double preferredStockComponent;

    public static double getPreferredStockComponent() {
        return preferredStockComponent;
    }

    /**
     * B38/B37
     */
    public static void setPreferredStockComponent() {
        preferredStockComponent = InputForCapital.getB38AnnualDividedPerShare()/InputForCapital.getB37CurrentMarketPricePerShare();
    }
}
