package com.back.example.CostOfCapital;

import com.back.StaticData.InputData;

import java.util.Objects;

public class CostC45LeveredBetaForEquity {
    static double leveredBetaForEquity;

    public static double getLeveredBetaForEquity() {
        return leveredBetaForEquity;
    }

    public static void setLeveredBetaForEquity() {
        double B11UnLeveredBeta = CostB11UnleveredBeta.getUnLeveredBeta();
        double B26TaxRate = InputData.getB21();
        double B48MarketEquity = CostB48MarketEquity.getMarketEquity();
        double C48MarketDebt = CostC48MarketDebt.getMarketDebt();
        String type = InputForCapital.getB9ApproachForEstimatingBeta();
        if (Objects.equals(type, "Direct Input")) {
            leveredBetaForEquity = InputForCapital.getB10leveredBeta();
        } else {
            leveredBetaForEquity = B11UnLeveredBeta * (1 + (1 - B26TaxRate) * (C48MarketDebt / B48MarketEquity));
        }


    }
}
