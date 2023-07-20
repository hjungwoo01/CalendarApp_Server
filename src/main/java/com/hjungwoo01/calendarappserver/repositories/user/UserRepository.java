package com.hjungwoo01.calendarappserver.repositories.user;

import com.hjungwoo01.calendarappserver.model.user.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUuid(String uuid);

    @Modifying
    @Transactional
    @Query("delete from User where name = :name")
    void deleteUsersByName(@Param("name") String name);
}
