package com.back.example.CostOfCapital;

import javafx.scene.effect.InnerShadow;

public class SyntheticRating {
    public static double LargerSaferFirms(double InterestConvergeRatio){
        if (InterestConvergeRatio < 0.2) {
            return RatingSpread.ratingSpread.get("D2/D");
        } else if (InterestConvergeRatio >= 0.2 && InterestConvergeRatio < 0.65) {
            return RatingSpread.ratingSpread.get("Caa/CCC");
        } else if (InterestConvergeRatio >= 0.65 && InterestConvergeRatio < 0.8) {
            return RatingSpread.ratingSpread.get("Ca2/CC");
        } else if (InterestConvergeRatio >= 0.8 && InterestConvergeRatio < 1.25) {
            return RatingSpread.ratingSpread.get("C2/C");
        } else if (InterestConvergeRatio >= 1.25 && InterestConvergeRatio < 1.5) {
            return RatingSpread.ratingSpread.get("B3/B-");
        } else if (InterestConvergeRatio >= 1.5 && InterestConvergeRatio < 1.75) {
            return RatingSpread.ratingSpread.get("B2/B");
        } else if (InterestConvergeRatio >= 1.75 && InterestConvergeRatio < 2) {
            return RatingSpread.ratingSpread.get("B1/B+");
        } else if (InterestConvergeRatio >= 2 && InterestConvergeRatio < 2.25) {
            return RatingSpread.ratingSpread.get("Ba2/BB");
        } else if (InterestConvergeRatio >= 2.25 && InterestConvergeRatio < 2.5) {
            return RatingSpread.ratingSpread.get("Ba1/BB+");
        } else if (InterestConvergeRatio >= 2.5 && InterestConvergeRatio < 3) {
            return RatingSpread.ratingSpread.get("Baa2/BBB");
        } else if (InterestConvergeRatio >= 3 && InterestConvergeRatio < 4.25) {
            return RatingSpread.ratingSpread.get("A3/A-");
        } else if (InterestConvergeRatio >= 4.25 && InterestConvergeRatio < 5.5) {
            return RatingSpread.ratingSpread.get("A2/A");
        } else if (InterestConvergeRatio >= 5.5 && InterestConvergeRatio < 6.5) {
            return RatingSpread.ratingSpread.get("A1/A+");
        } else if (InterestConvergeRatio >= 6.5 && InterestConvergeRatio < 8.5) {
            return RatingSpread.ratingSpread.get("Aa2/AA");
        } else {
            return RatingSpread.ratingSpread.get("Aaa/AAA");
        }
    }

    public static double SmallerRiskierFirms(double InterestConvergeRatio){
        if (InterestConvergeRatio < 0.5) {
            return RatingSpread.ratingSpread.get("D2/D");
        } else if (InterestConvergeRatio >= 0.5 && InterestConvergeRatio < 0.8) {
            return RatingSpread.ratingSpread.get("Caa/CCC");
        } else if (InterestConvergeRatio >= 0.8 && InterestConvergeRatio < 1.25) {
            return RatingSpread.ratingSpread.get("Ca2/CC");
        } else if (InterestConvergeRatio >= 1.25 && InterestConvergeRatio < 1.5) {
            return RatingSpread.ratingSpread.get("C2/C");
        } else if (InterestConvergeRatio >= 1.5 && InterestConvergeRatio < 2) {
            return RatingSpread.ratingSpread.get("B3/B-");
        } else if (InterestConvergeRatio >= 2 && InterestConvergeRatio < 2.5) {
            return RatingSpread.ratingSpread.get("B2/B");
        } else if (InterestConvergeRatio >= 2.5 && InterestConvergeRatio < 3) {
            return RatingSpread.ratingSpread.get("B1/B+");
        } else if (InterestConvergeRatio >= 3 && InterestConvergeRatio < 3.5) {
            return RatingSpread.ratingSpread.get("Ba2/BB");
        } else if (InterestConvergeRatio >= 3.5 && InterestConvergeRatio < 4) {
            return RatingSpread.ratingSpread.get("Ba1/BB+");
        } else if (InterestConvergeRatio >= 4 && InterestConvergeRatio < 4.5) {
            return RatingSpread.ratingSpread.get("Baa2/BBB");
        } else if (InterestConvergeRatio >= 4.5 && InterestConvergeRatio < 6) {
            return RatingSpread.ratingSpread.get("A3/A-");
        } else if (InterestConvergeRatio >= 6 && InterestConvergeRatio < 7.5) {
            return RatingSpread.ratingSpread.get("A2/A");
        } else if (InterestConvergeRatio >= 7.5 && InterestConvergeRatio < 9.5) {
            return RatingSpread.ratingSpread.get("A1/A+");
        } else if (InterestConvergeRatio >= 9.5 && InterestConvergeRatio < 12.5) {
            return RatingSpread.ratingSpread.get("Aa2/AA");
        } else {
            return RatingSpread.ratingSpread.get("Aaa/AAA");
        }
    }
}
