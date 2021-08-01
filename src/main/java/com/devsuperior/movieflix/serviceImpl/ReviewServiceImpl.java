package com.devsuperior.movieflix.serviceImpl;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entity.Movie;
import com.devsuperior.movieflix.entity.Review;
import com.devsuperior.movieflix.repository.MovieRepository;
import com.devsuperior.movieflix.repository.ReviewRepository;
import com.devsuperior.movieflix.service.ReviewService;
import com.devsuperior.movieflix.serviceImpl.exception.ResourceEntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class ReviewServiceImpl implements ReviewService {


    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private AuthServiceImpl authService;

    @Override
    @Transactional
    public ReviewDTO insert(ReviewDTO dto) {
        Review review = new Review();
        copyDtoToEntity(dto, review);
        review.setUser(authService.authenticated());
        review = reviewRepository.save(review);
        return new ReviewDTO(review);
    }

    private void copyDtoToEntity(ReviewDTO dto, Review entity){
        entity.setText(dto.getText());
        try {
            Movie movie = movieRepository.getOne(dto.getMovieId());
            entity.setMovie(movie);
        } catch (EntityNotFoundException e) {
            throw new ResourceEntityNotFoundException("Movie id not found "+ dto.getId());
        }

    }
}
