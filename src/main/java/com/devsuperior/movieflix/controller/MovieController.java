package com.devsuperior.movieflix.controller;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.MovieMinDTO;
import com.devsuperior.movieflix.serviceImpl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    MovieServiceImpl movieService;

    @GetMapping
    public ResponseEntity<Page<MovieMinDTO>> findAll(
            @RequestParam(name = "genreId", defaultValue = "0") Long genreId,
            Pageable pageable){

        Page<MovieMinDTO> page = movieService.findAll(genreId, pageable);
        return ResponseEntity.ok().body(page);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MovieDTO> findById(@PathVariable Long id){
        MovieDTO movie = movieService.findById(id);
        return ResponseEntity.ok().body(movie);
    }
}
