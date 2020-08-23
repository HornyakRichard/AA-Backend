package com.richard.AssecoTest.repository.user;

import com.richard.AssecoTest.common.domain.UserData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserData, Long> {

    Optional<UserData> findByUsername(String username);

    Optional<UserData> findById(final long id);
}
