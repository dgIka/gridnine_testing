package com.gridnine.testing.rules;

import com.gridnine.testing.Flight;


public class ArrivalBeforeDepartureRule implements Rule {
    @Override
    public boolean execute(Flight flight) {
        return flight.getSegments()
                .stream()
                .anyMatch(departure -> departure.getArrivalDate().isBefore(departure.getDepartureDate()));
    }
}
