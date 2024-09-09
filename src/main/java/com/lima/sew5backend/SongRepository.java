package com.lima.sew5backend;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "songs", path = "songs")
public interface SongRepository extends PagingAndSortingRepository<Song, Long>, CrudRepository<Song, Long> {

    List<Song> findByTitle(@Param("title") String title);

    List<Song> findByArtist(@Param("artist") String artist);

    Song findById(long id);
}
