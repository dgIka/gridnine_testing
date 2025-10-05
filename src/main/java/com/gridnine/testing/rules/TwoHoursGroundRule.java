package com.gridnine.testing.rules;

import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class TwoHoursGroundRule implements Rule {
    static final long TWO_HOURS_SEC = 7200;
    @Override
    public boolean execute(Flight flight) {
        List<Segment> segments = flight.getSegments();
        long onTheGround = 0;
        for (int i = 0; i < segments.size() - 1; i++) {
            LocalDateTime arrival = segments.get(i).getArrivalDate();
            LocalDateTime departure = segments.get(i + 1).getDepartureDate();
            onTheGround +=  Duration.between(arrival, departure).getSeconds();
        }
        return onTheGround > TWO_HOURS_SEC;
    }
}
