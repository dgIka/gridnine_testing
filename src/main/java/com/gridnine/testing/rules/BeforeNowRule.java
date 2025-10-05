package com.gridnine.testing.rules;

import com.gridnine.testing.Flight;

import java.time.LocalDateTime;

public class BeforeNowRule implements Rule {
    @Override
    public boolean execute(Flight flight) {
        return flight.getSegments()
                .stream()
                .anyMatch(departure -> departure.getDepartureDate().isBefore(LocalDateTime.now()));
    }
}
