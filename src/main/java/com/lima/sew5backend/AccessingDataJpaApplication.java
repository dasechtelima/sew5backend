package com.lima.sew5backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootApplication
public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class);
    }

    @Bean
    public CommandLineRunner demo(SongRepository repository) {
        return (args) -> {
            repository.save(new Song("Happy Enough", "Tors", "Indie", 202));
            repository.save(new Song("Miracle", "Tors", "Indie", 182));
            repository.save(new Song("Stargazing", "Myles Smith", "Pop", 172));
            repository.save(new Song("Stargazing", "OneRepublic", "Rock", 271));
            repository.save(new Song("Stick Season", "Noah Kahan", "Indie", 202));
            repository.save(new Song("Northern Attitude", "Noah Kahan", "Indie", 182));
            repository.save(new Song("False Confidence", "Noah Kahan", "Indie", 172));
            repository.save(new Song("Meer", "Jeremias", "Indie", 202));
            repository.save(new Song("Rote Flaggen", "Berq", "Indie", 182));
            repository.save(new Song("Sailor Song", "Gigi Perez", "Indie", 172));
            repository.save(new Song("All my Love", "Noah Kahan", "Indie", 202));
            repository.save(new Song("Hurt Somebody", "Noah Kahan", "Indie", 182));
            repository.save(new Song("Young Blood", "Noah Kahan", "Indie", 172));
            repository.save(new Song("The View between Villages", "Noah Kahan", "Indie", 202));
            repository.save(new Song("Homesick", "Noah Kahan", "Indie", 182));
            repository.save(new Song("Home", "Matthew Hall", "Indie", 172));

            // Fetch all songs with pagination
            Page<Song> allProducts = repository.findAll(PageRequest.of(0, 5));
            log.info("Songs found with findAll(Pageable):");
            log.info("-------------------------------");
            allProducts.forEach(song -> log.info(song.toString()));
        };
    }
}