package com.lima.sew5backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class);
    }

    @Bean
    public CommandLineRunner demo(SongRepository repository, ArtistRepository artistRepository) {
        Artist Tors = new Artist("Tors");
        Artist MylesSmith = new Artist("Myles Smith");
        Artist OneRepublic = new Artist("OneRepublic");
        Artist NoahKahan = new Artist("Noah Kahan");
        Artist Jeremias = new Artist("Jeremias");
        Artist Berq = new Artist("Berq");
        Artist GigiPerez = new Artist("Gigi Perez");
        Artist MatthewHall = new Artist("Matthew Hall");
        return (args) -> {
            //artists
            artistRepository.save(Tors);
            artistRepository.save(MylesSmith);
            artistRepository.save(OneRepublic);
            artistRepository.save(NoahKahan);
            artistRepository.save(Jeremias);
            artistRepository.save(Berq);
            artistRepository.save(GigiPerez);
            artistRepository.save(MatthewHall);
            //genres
            Set<Genre> indie = new HashSet<>();
            Genre indieGenre = new Genre("Indie");
            indie.add(indieGenre);
            Set<Genre> pop = new HashSet<>();
            Genre popGenre = new Genre("Pop");
            pop.add(popGenre);
            Set<Genre> rock = new HashSet<>();
            Genre rockGenre = new Genre("Rock");
            rock.add(rockGenre);
            Set<Genre> indiePop = new HashSet<>();
            indiePop.add(indieGenre);
            indiePop.add(popGenre);
            //songs
            repository.save(new Song("Happy Enough", Tors, indiePop, 202, ""));
            repository.save(new Song("Miracle", Tors, indiePop, 182, ""));
            repository.save(new Song("Stargazing", MylesSmith, pop, 172, ""));
            repository.save(new Song("Stargazing", OneRepublic, rock, 271, ""));
            repository.save(new Song("Stick Season", NoahKahan, indie, 202, ""));
            repository.save(new Song("Northern Attitude", NoahKahan, indie, 182, ""));
            repository.save(new Song("False Confidence", NoahKahan, indie, 172, ""));
            repository.save(new Song("Meer", Jeremias, indie, 202, ""));
            repository.save(new Song("Rote Flaggen", Berq, indie, 182, ""));
            repository.save(new Song("Sailor Song", GigiPerez, indie, 172, ""));
            repository.save(new Song("All my Love", NoahKahan, indie, 202, ""));
            repository.save(new Song("Hurt Somebody", NoahKahan, indie, 182, ""));
            repository.save(new Song("Young Blood", NoahKahan, indie, 172, ""));
            repository.save(new Song("The View between Villages", NoahKahan, indie, 202, ""));
            repository.save(new Song("Homesick", NoahKahan, indie, 182, ""));
            repository.save(new Song("Home", MatthewHall, indiePop, 172, ""));

            // Fetch all songs
            Page<Song> allProducts = repository.findAll(PageRequest.of(0, 5));
            log.info("Songs found with findAll(Pageable):");
            log.info("-------------------------------");
            //allProducts.forEach(song -> log.info(song.toString()));

            //Fetch all artists
            Page<Artist> allArtists = artistRepository.findAll(PageRequest.of(0, 5));
            log.info("Artists found with findAll(Pageable):");
            log.info("-------------------------------");
            allArtists.forEach(artist -> log.info(artist.toString()));
        };
    }
}