
import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;
import com.gridnine.testing.rules.ArrivalBeforeDepartureRule;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArrivalBeforeDepartureRuleTest {

    @Test
    void shouldReturnTrueWhenArrivalBeforeDeparture() {
        LocalDateTime time = LocalDateTime.now().plusDays(1);

        Flight flight = new Flight(List.of(new Segment(time, time.minusHours(1))));

        assertTrue(new ArrivalBeforeDepartureRule().execute(flight));
    }

    @Test
    void returnsFalseForNormalSegment() {
        LocalDateTime time = LocalDateTime.now().plusDays(1);

        Flight flight = new Flight(List.of(new Segment(time, time.plusHours(2))));

        assertFalse(new ArrivalBeforeDepartureRule().execute(flight));
    }
}