package com.devsuperior.movieflix.serviceImpl;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.MovieMinDTO;
import com.devsuperior.movieflix.entity.Movie;
import com.devsuperior.movieflix.repository.MovieRepository;
import com.devsuperior.movieflix.service.MovieService;
import com.devsuperior.movieflix.serviceImpl.exception.ResourceEntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<MovieMinDTO> findAll(Long genreId, Pageable pageable) {
        genreId = genreId == 0 ? null : genreId;
        Page<Movie> page = movieRepository.find(genreId, pageable);
        Page<MovieMinDTO> listDto = page.map(x -> new MovieMinDTO(x));
        return listDto;
    }

    @Override
    @Transactional(readOnly = true)
    public MovieDTO findById(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        Movie entity = movie.orElseThrow(() -> new ResourceEntityNotFoundException("Entity not found"));
        return new MovieDTO(entity);
    }
}
