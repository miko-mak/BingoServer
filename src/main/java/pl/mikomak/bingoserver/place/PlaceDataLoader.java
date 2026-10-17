package pl.mikomak.bingoserver.place;

import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import tools.jackson.databind.json.JsonMapper;

import java.util.Arrays;
import java.io.InputStream;

@Component
public class PlaceDataLoader implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(PlaceDataLoader.class);
    private final PlaceRepository placeRepository;
    private final JsonMapper jsonMapper;

    public PlaceDataLoader(PlaceRepository placeRepository, JsonMapper jsonMapper) {
        this.placeRepository = placeRepository;
        this.jsonMapper = jsonMapper;
    }

    @Override
    public void run(String @NonNull ... args) {
        try (InputStream placesStream = new ClassPathResource("places.json").getInputStream()) {
            Place[] places = this.jsonMapper.readValue(placesStream, Place[].class);
            this.placeRepository.saveAll(Arrays.asList(places));
            log.info("Places loaded into database: {}", this.placeRepository.count());

        } catch(Exception e) {
            log.error("Cannot load places into database ", e);
        }
    }
}
