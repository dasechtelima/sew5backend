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
            //songs
            repository.save(new Song("Happy Enough", Tors, "Indie", 202, ""));
            repository.save(new Song("Miracle", Tors, "Indie", 182, ""));
            repository.save(new Song("Stargazing", MylesSmith, "Pop", 172, ""));
            repository.save(new Song("Stargazing", OneRepublic, "Rock", 271, ""));
            repository.save(new Song("Stick Season", NoahKahan, "Indie", 202, ""));
            repository.save(new Song("Northern Attitude", NoahKahan, "Indie", 182, ""));
            repository.save(new Song("False Confidence", NoahKahan, "Indie", 172, ""));
            repository.save(new Song("Meer", Jeremias, "Indie", 202, ""));
            repository.save(new Song("Rote Flaggen", Berq, "Indie", 182, ""));
            repository.save(new Song("Sailor Song", GigiPerez, "Indie", 172, ""));
            repository.save(new Song("All my Love", NoahKahan, "Indie", 202, ""));
            repository.save(new Song("Hurt Somebody", NoahKahan, "Indie", 182, ""));
            repository.save(new Song("Young Blood", NoahKahan, "Indie", 172, ""));
            repository.save(new Song("The View between Villages", NoahKahan, "Indie", 202, ""));
            repository.save(new Song("Homesick", NoahKahan, "Indie", 182, ""));
            repository.save(new Song("Home", MatthewHall, "Indie", 172, ""));

            // Fetch all songs
            Page<Song> allProducts = repository.findAll(PageRequest.of(0, 5));
            log.info("Songs found with findAll(Pageable):");
            log.info("-------------------------------");
            allProducts.forEach(song -> log.info(song.toString()));

            //Fetch all artists
            Page<Artist> allArtists = artistRepository.findAll(PageRequest.of(0, 5));
            log.info("Artists found with findAll(Pageable):");
            log.info("-------------------------------");
            allArtists.forEach(artist -> log.info(artist.toString()));
        };
    }
}