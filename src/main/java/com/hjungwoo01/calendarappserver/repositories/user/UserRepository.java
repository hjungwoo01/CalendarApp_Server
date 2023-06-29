package com.hjungwoo01.calendarappserver.repositories.user;

import com.hjungwoo01.calendarappserver.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
