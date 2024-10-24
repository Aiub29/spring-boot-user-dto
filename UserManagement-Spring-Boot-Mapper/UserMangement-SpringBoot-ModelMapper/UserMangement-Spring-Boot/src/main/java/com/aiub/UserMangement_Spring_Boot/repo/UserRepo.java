package com.aiub.UserMangement_Spring_Boot.repo;

import com.aiub.UserMangement_Spring_Boot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
}
