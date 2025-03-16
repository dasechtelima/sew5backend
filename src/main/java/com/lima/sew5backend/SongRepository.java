package com.lima.sew5backend;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.core.config.Projection;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Set;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "songs", path = "songs", excerptProjection = SongProjection.class)
public interface SongRepository extends PagingAndSortingRepository<Song, Long>, CrudRepository<Song, Long> {

    @CrossOrigin
    @RestResource(path = "searchSongs", rel = "searchSongs")
    @Query("SELECT s FROM Song s JOIN s.artist a JOIN s.genre g WHERE LOWER(s.title) LIKE LOWER(CONCAT('%', :title, '%')) OR LOWER(a.name) LIKE LOWER(CONCAT('%', :artist_name, '%')) OR LOWER(g.name) LIKE LOWER(CONCAT('%', :genre_name, '%'))")
    Page<Song> findSongsByTitleContainingIgnoreCaseOrArtistNameContainingIgnoreCaseOrGenreNameContainingIgnoreCase(@Param("title") String title, @Param("artist_name") String artist_name, @Param("genre_name") String genre_name, Pageable pageable);
}

@Projection(name = "songWithArtist", types = {Song.class})
interface SongProjection {
    String getTitle();

    Artist getArtist();

    Set<Genre> getGenre();

    int getLength();

    int getVersion();
}

@Projection(name = "songFile", types = {Song.class})
interface SongFileProjection {
    String getFile();
}
