package com.lima.sew5backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class);
    }

    @Bean
    public CommandLineRunner demo(SongRepository repository) {
        return (args) -> {
            // save a few songs
            repository.save(new Song("Happy Enough", "Tors", "Indie", 202));
            repository.save(new Song("Miracle", "Tors", "Indie", 182));
            repository.save(new Song("Stargazing", "Myles Smith", "Pop", 172));
            repository.save(new Song("Stargazing", "OneRepublic", "Rock", 271));

            // fetch all songs
            log.info("Songs found with findAll():");
            log.info("-------------------------------");
            repository.findAll().forEach(song -> {
                log.info(song.toString());
            });
            log.info("");

            // fetch an individual song by ID
            Song song = repository.findById(1);
            log.info("Song found with findById(1):");
            log.info("--------------------------------");
            log.info(song.toString());
            log.info("");

            // fetch songs by title
            log.info("Song found with findByTitle('Stargazing'):");
            log.info("--------------------------------------------");
            repository.findByTitle("Stargazing").forEach(title -> {
                log.info(title.toString());
            });
            log.info("");

            // fetch songs by artist
            log.info("Song found with findByArtist('Tors'):");
            log.info("--------------------------------------------");
            repository.findByArtist("Tors").forEach(artist -> {
                log.info(artist.toString());
            });
            log.info("");
        };
    }

}
