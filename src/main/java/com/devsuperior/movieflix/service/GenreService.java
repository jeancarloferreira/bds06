package com.devsuperior.movieflix.service;

import com.devsuperior.movieflix.dto.GenreDTO;

import java.util.List;

public interface GenreService {

    List<GenreDTO> findAll();
}
