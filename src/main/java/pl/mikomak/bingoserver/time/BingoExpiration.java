package pl.mikomak.bingoserver.time;

import java.time.LocalDate;

public record BingoExpiration(LocalDate date, long secondsLeft) { }
