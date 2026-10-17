package pl.mikomak.bingoserver.board;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.mikomak.bingoserver.place.Place;

import java.util.List;

@Document(collection = "boards")
public class Board {
    @Id
    private final String date;
    private final List<Place> places;

    public Board(String date, List<Place> places) {
        this.date = date;
        this.places = places;
    }

    public String getDate() {
        return this.date;
    }

    public List<Place> getPlaces() {
        return this.places;
    }
}
