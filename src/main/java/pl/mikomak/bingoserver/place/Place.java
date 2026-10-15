package pl.mikomak.bingoserver.place;

import org.jspecify.annotations.Nullable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Place {
    @Id
    public @Nullable String id;
    public String name;
    public double lat;
    public double lon;
    public double radiusMeters;

    public Place() {}

    public Place(String name, double lat, double lon, double radiusMeters) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.radiusMeters = radiusMeters;
    }
}
