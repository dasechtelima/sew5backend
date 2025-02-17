package com.lima.sew5backend;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.core.config.Projection;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "songs", path = "songs")
public interface SongRepository extends PagingAndSortingRepository<Song, Long>, CrudRepository<Song, Long> {

    @CrossOrigin
    @RestResource(path = "findByTitleIgnoreCaseContainingOrArtistIgnoreCaseContainingOrGenreIgnoreCaseContaining", rel = "findByTitleIgnoreCaseContainingOrArtistIgnoreCaseContainingOrGenreIgnoreCaseContaining")
    List<Song> findByTitleIgnoreCaseContainingOrArtistNameOrGenre(String title, String artist_name, String genre);
}

@Projection(name = "songWithArtist", types = {Song.class})
interface SongProjection {
    String getTitle();
    Artist getArtist();
    String getGenre();
    int getLength();
    int getVersion();
}

@Projection(name = "songFile", types = {Song.class})
interface SongFileProjection {
    String getFile();
}
