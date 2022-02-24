package com.example.seoullite.user.service;

import com.example.seoullite.common.util.RedisUtil;
import com.example.seoullite.repository.UserRepository;
import com.example.seoullite.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeoutException;

@RequiredArgsConstructor

@Service
public class UserService {

    private final RedisUtil redisUtil;
    private final UserRepository userRepository;

    public void registerUser(String key) throws TimeoutException {

        User user = (User)redisUtil.get(key);

        if(user== null) {
            throw new TimeoutException();
        } else {
            try {
                userRepository.save(user);
                redisUtil.delete(key);
            } catch (Exception e) {

            }

        }

    }
}
