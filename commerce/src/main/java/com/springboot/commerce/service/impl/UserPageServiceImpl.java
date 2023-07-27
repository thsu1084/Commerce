package com.springboot.commerce.service.impl;

import com.springboot.commerce.data.entity.User;
import com.springboot.commerce.data.repository.UserRepository;
import com.springboot.commerce.service.UserPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UserPageServiceImpl implements UserPageService {
    private final UserRepository userRepository;

    @Override
    public User findUser(Long id) {
        return userRepository.findById(id).get();
    }
}
