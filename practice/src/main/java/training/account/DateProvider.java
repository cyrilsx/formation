package training.account;

import java.time.Clock;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicReference;

public class DateProvider {
    private final AtomicReference<Clock> currentClock = new AtomicReference<>();

    public LocalDate now() {
        return LocalDate.now(currentClock.get());
    }

}
