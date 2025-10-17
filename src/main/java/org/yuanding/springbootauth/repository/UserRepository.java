package org.yuanding.springbootauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yuanding.springbootauth.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

    User findByEmail(String email);

    User findByUserNameOrEmail(String username, String email);

}