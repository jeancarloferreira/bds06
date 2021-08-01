package com.devsuperior.movieflix.controller;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.entity.Genre;
import com.devsuperior.movieflix.serviceImpl.GenreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/genres")
public class GenreController {

    @Autowired
    GenreServiceImpl genreService;

    @GetMapping()
    public ResponseEntity<List<GenreDTO>> findAll(){
        List<GenreDTO> list = genreService.findAll();
        return ResponseEntity.ok().body(list);
    };

}
