package com.back.example.CostOfCapital;

import java.util.HashMap;
import java.util.Map;

public class RatingSpread {
    // The data in the map all has the percent sign %
    public final static Map<String,Double> ratingSpread  = new HashMap<>(){{
        put("A1/A+",0.975);
        put("A2/A",1.0764);
        put("A3/A-",1.2168);
        put("Aa2/AA",0.78);
        put("Aaa/AAA",0.63);
        put("B1/B+",3.51);
        put("B2/B",4.212);
        put("B3/B-",5.148);
        put("Ba1/BB+",2.0);
        put("Ba2/BB",2.4);
        put("Baa2/BBB",1.56);
        put("C2/C",11.3412);
        put("Ca2/CC",8.6424);
        put("Caa/CCC",8.2);
        put("D2/D",15.1164);
    }};



}
