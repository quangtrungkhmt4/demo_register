package com.demoregister.demo_register.repository;

import com.demoregister.demo_register.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByNameAndPhone(String name, String phone);

    @Query(nativeQuery = true, value = "select * from user where name like %:name% order by name asc limit :limit offset :offset")
    List<User> findAllByNameLikeNativeQuery(@Param("name") String name, @Param("limit") int limit, @Param("offset") int offset);

    List<User> findAllByNameContaining(String name, Pageable p);

}
