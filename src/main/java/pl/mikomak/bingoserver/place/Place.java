package pl.mikomak.bingoserver.place;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "places")
public class Place {
    @JsonProperty("_id")
    @Id
    public @Nullable String id;
    public String name;
    public double lat;
    public double lon;

    public Place() {}

    public Place(String name, double lat, double lon) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
    }
}
