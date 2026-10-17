package pl.mikomak.bingoserver.board;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.mikomak.bingoserver.place.Place;

import java.util.List;

@Document(collection = "boards")
public class Board {
    @Id
    private final String id;
    private final List<Place> places;

    public Board(String id, List<Place> places) {
        this.places = places;
        this.id = id;
    }

    public List<Place> getPlaces() {
        return this.places;
    }
}
