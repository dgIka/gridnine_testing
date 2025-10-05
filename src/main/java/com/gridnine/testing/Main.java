package com.gridnine.testing;


import com.gridnine.testing.rules.ArrivalBeforeDepartureRule;
import com.gridnine.testing.rules.BeforeNowRule;
import com.gridnine.testing.rules.TwoHoursGroundRule;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        System.out.println("Вылет до текущего момента времени");
        FlightFilter.filterAndPrint(flights, new BeforeNowRule());
        System.out.println();
        System.out.println("Имеются сегменты с датой прилета раньше даты вылета");
        FlightFilter.filterAndPrint(flights, new ArrivalBeforeDepartureRule());
        System.out.println();
        System.out.println("Общее время. проведенное на земле превышает два часа (время на земле - " +
                "это интервал между прилетом одного сегмента и вылетом следующего за ним");
        FlightFilter.filterAndPrint(flights, new TwoHoursGroundRule());

    }
}
