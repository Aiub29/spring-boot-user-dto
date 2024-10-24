package com.aiub.UserMangement_Spring_Boot.mapper;

import com.aiub.UserMangement_Spring_Boot.dto.UserDto;
import com.aiub.UserMangement_Spring_Boot.entity.User;

public class UserMapper {
    // Convert User JPA Entity into UserDto

    public static UserDto mapToUserDto(User user) {

        UserDto userDto = new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return userDto;

        // convert UserDto into User JPA Entity

    }
    public static User mapToUser(UserDto userDto){
        User user =new User(
           userDto.getId(),
           userDto.getFirstName(),
           userDto.getLastName(),
           userDto.getEmail()
        );
        return  user;
    }
}
