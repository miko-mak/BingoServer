package pl.mikomak.bingoserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;
import java.time.ZoneId;

@Configuration
public class ClockConfiguration {

    private final static ZoneId ZONE_ID = ZoneId.of("Europe/Warsaw");

    @Bean
    public Clock getClock() {
        return Clock.system(ZONE_ID);
    }
}
