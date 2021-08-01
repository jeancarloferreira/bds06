package com.devsuperior.movieflix.serviceImpl;

import com.devsuperior.movieflix.entity.User;
import com.devsuperior.movieflix.repository.UserRepository;
import com.devsuperior.movieflix.service.AuthService;
import com.devsuperior.movieflix.serviceImpl.exception.AnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public User authenticated() {
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();

            return userRepository.findByEmail(username);
        } catch (Exception e) {
            throw new AnauthorizedException("Invalid user");
        }
    }
}
