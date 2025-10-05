package com.gridnine.testing;

import com.gridnine.testing.rules.Rule;

import java.util.List;

public class FlightFilter {
    public static void filterAndPrint(List<Flight> flights, Rule rule) {
        for (Flight flight : flights) {
            if (!rule.execute(flight)){
                System.out.println(flight);}
        }
    }
}
