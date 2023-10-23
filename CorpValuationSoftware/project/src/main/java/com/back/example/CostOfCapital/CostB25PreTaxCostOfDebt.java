package com.back.example.CostOfCapital;

import com.back.StaticData.InputData;


import java.util.Objects;

public class CostB25PreTaxCostOfDebt {
    public static double getPreTaxCostOfDebt() {
        return PreTaxCostOfDebt;
    }

    public static void setPreTaxCostOfDebt() {
        String ApproachType = InputForCapital.B21ApproachForPreTaxCostOfDebt;
        String rating = InputForCapital.B23ActualRating;
        String syntheticRating = InputForCapital.B24SyntheticRatingType;
        double EBIT = InputData.getB9();
        double interestExpense = InputData.getB10();
        if(Objects.equals(ApproachType, "Direct Input")){
            PreTaxCostOfDebt = InputForCapital.getB22DirectInputPreTaxCostOfDebt();
        } else if (Objects.equals(ApproachType, "Actual rating")) {
            PreTaxCostOfDebt = InputData.getB30() + 0.01 * RatingSpread.ratingSpread.get(rating);
        } else if(Objects.equals(ApproachType, "Synthetic rating")){
            double interestConvergeRatio = EBIT/interestExpense;
            if(Objects.equals(syntheticRating, "1")){
                PreTaxCostOfDebt = 0.01 * SyntheticRating.LargerSaferFirms(interestConvergeRatio);
            } else if(Objects.equals(syntheticRating, "2")){
                PreTaxCostOfDebt = 0.01 * SyntheticRating.SmallerRiskierFirms(interestConvergeRatio);
            }
        }
    }

    private static double PreTaxCostOfDebt;

}
