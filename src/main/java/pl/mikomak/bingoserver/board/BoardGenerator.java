package pl.mikomak.bingoserver.board;

import pl.mikomak.bingoserver.place.Place;

import java.time.LocalDate;
import java.util.*;


public final class BoardGenerator {
    private final static int BOARD_SIZE = 16;

    public static Board generateBoard(LocalDate date, List<Place> places) {
        if (places.size() < BOARD_SIZE) {
            throw new IllegalStateException("Cannot generate full board. Not enough places");
        }

        List<Place> copy = new ArrayList<>(places);
        Collections.shuffle(copy);
        return new Board(date.toString(), copy.subList(0, BOARD_SIZE));
    }
}
