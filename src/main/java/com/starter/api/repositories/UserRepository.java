package com.starter.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.starter.api.domain.UserLogin;

@Repository
public interface UserRepository extends JpaRepository<UserLogin, Integer> {

}
