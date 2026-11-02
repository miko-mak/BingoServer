package pl.mikomak.bingoserver;

import org.junit.jupiter.api.Test;
import pl.mikomak.bingoserver.time.BingoExpiration;
import pl.mikomak.bingoserver.time.BingoTimeService;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BingoTimeServiceTest {

    private static final ZoneId WARSAW = ZoneId.of("Europe/Warsaw");

    @Test
    void shouldReturnOneSecondLeftJustBeforeMidnight() {
        Clock clock = Clock.fixed(Instant.parse("2026-11-02T22:59:59Z"), WARSAW);
        BingoTimeService service = new BingoTimeService(clock);

        BingoExpiration result = service.getBingoExpiration();

        assertEquals(LocalDate.of(2026, 11, 2), result.date());
        assertEquals(1, result.secondsLeft());
    }

    @Test
    void shouldStartNewDayWithFullDayExpiration() {
        Clock clock = Clock.fixed(Instant.parse("2026-11-02T23:00:00Z"), WARSAW);
        BingoTimeService service = new BingoTimeService(clock);

        BingoExpiration result = service.getBingoExpiration();

        assertEquals(LocalDate.of(2026, 11, 3), result.date());
        assertEquals(86400, result.secondsLeft());
    }
}