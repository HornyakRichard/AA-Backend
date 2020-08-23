package com.richard.AssecoTest.service.user;

import com.richard.AssecoTest.common.domain.UserData;
import com.richard.AssecoTest.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void addUser(UserData userData) {
        userRepository.save(userData);
    }

    @Override
    public List<UserData> getUsers() {

        return userRepository.findAll();
    }

    @Override
    public UserData getUserById(final long id) {
        return userRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NO_CONTENT, "No record with the given id"));
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }
}
