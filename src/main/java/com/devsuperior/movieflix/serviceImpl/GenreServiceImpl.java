package com.devsuperior.movieflix.serviceImpl;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.entity.Genre;
import com.devsuperior.movieflix.repository.GenreRepository;
import com.devsuperior.movieflix.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    GenreRepository genreRepository;

    @Override
    @Transactional(readOnly = true)
    public List<GenreDTO> findAll() {
        List<Genre> list = genreRepository.findAll();
        List<GenreDTO> listDto = list.stream().map(x -> new GenreDTO(x)).collect(Collectors.toList());
        return listDto;
    }
}
