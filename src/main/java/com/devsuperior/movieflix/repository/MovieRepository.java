package com.devsuperior.movieflix.repository;

import com.devsuperior.movieflix.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(value = "SELECT obj " +
            "FROM Movie obj " +
            "WHERE (COALESCE(:genreId) IS NULL OR obj.genre.id = :genreId) " +
            "ORDER BY obj.title ASC")
    Page<Movie> find(Long genreId, Pageable pageable);

}
