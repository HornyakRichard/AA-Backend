package com.richard.AssecoTest.service.user;

import com.richard.AssecoTest.common.domain.UserData;

import java.util.List;

public interface UserService {

    void addUser(final UserData userData);

    List<UserData> getUsers();

    UserData getUserById(final long id);

    void deleteUserById(final long id);
}
