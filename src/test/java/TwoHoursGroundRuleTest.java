import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;
import com.gridnine.testing.rules.TwoHoursGroundRule;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TwoHoursGroundRuleTest {

    @Test
    void shouldReturnTrueWhenTotalGroundTimeExceedsTwoHours() {
        LocalDateTime time = LocalDateTime.now().plusDays(1);
        Flight flight = new Flight(List.of(
                new Segment(time, time.plusHours(1)),
                new Segment(time.plusHours(4), time.plusHours(5))
        ));

        assertTrue(new TwoHoursGroundRule().execute(flight));
    }

    @Test
    void shouldReturnFalseWhenTotalGroundTimeIsTwoHoursOrLess() {
        LocalDateTime time = LocalDateTime.now().plusDays(1);
        Flight f = new Flight(List.of(
                new Segment(time, time.plusHours(1)),
                new Segment(time.plusHours(2).plusMinutes(30), time.plusHours(3))
        ));

        assertFalse(new TwoHoursGroundRule().execute(f));
    }
}
