package com.praveen.lib_manage;

import com.praveen.lib_manage.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
