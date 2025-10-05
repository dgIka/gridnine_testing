import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;
import com.gridnine.testing.rules.BeforeNowRule;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BeforeNowRuleTest {

    @Test
    void shouldReturnTrueWhenAnySegmentDepartsInPast() {
        LocalDateTime time = LocalDateTime.now();

        Flight flight = new Flight(List.of(new Segment(time.minusHours(1), time.plusHours(1))));

        assertTrue(new BeforeNowRule().execute(flight));
    }

    @Test
    void shouldReturnFalseWhenAllSegmentsInFuture() {
        LocalDateTime time = LocalDateTime.now().plusDays(1);

        Flight flight = new Flight(List.of(new Segment(time, time.plusHours(2))));

        assertFalse(new BeforeNowRule().execute(flight));
    }
}