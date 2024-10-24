package com.aiub.UserMangement_Spring_Boot.service;

import com.aiub.UserMangement_Spring_Boot.dto.UserDto;
import com.aiub.UserMangement_Spring_Boot.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto getUserById(Long userId);
    List<UserDto> getAllUser();
    UserDto updateUser(UserDto user);
    void deleteUser(Long userId);
}
