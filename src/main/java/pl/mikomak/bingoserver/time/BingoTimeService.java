package pl.mikomak.bingoserver.time;

import org.springframework.stereotype.Service;

import java.time.*;

@Service
public class BingoTimeService {

    private final Clock clock;

    public BingoTimeService(Clock clock) {
        this.clock = clock;
    }

    public BingoExpiration getBingoExpiration() {
        Instant now = this.clock.instant();
        long remainingSeconds = Duration.between(now, getEndTime(now)).toSeconds();
        return new BingoExpiration(now.atZone(this.clock.getZone()).toLocalDate(), remainingSeconds);
    }

    private Instant getEndTime(Instant now) {
        return now.atZone(this.clock.getZone())
                .toLocalDate()
                .plusDays(1)
                .atStartOfDay(this.clock.getZone())
                .toInstant();
    }
}
