package com.aiub.UserMangement_Spring_Boot.impl;

import com.aiub.UserMangement_Spring_Boot.dto.UserDto;
import com.aiub.UserMangement_Spring_Boot.entity.User;
import com.aiub.UserMangement_Spring_Boot.mapper.UserMapper;
import com.aiub.UserMangement_Spring_Boot.repo.UserRepo;
import com.aiub.UserMangement_Spring_Boot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;
    @Override
    public UserDto createUser(UserDto userDto) {
// Convert User Dto into User JPA Entity
//        User user = new User(
//                userDto.getId(),
//                userDto.getFirstName(),
//                userDto.getLastName(),
//                userDto.getEmail()
//        );

        User user= UserMapper.mapToUser(userDto);
        User savedUser = userRepo.save(user);
        // Convert User JPA Entity to UserDto
//        UserDto savedUserDto = new UserDto(
//                savedUser.getId(),
//                savedUser.getFirstName(),
//                savedUser.getLastName(),
//                savedUser.getEmail()
//        );

        UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
        return savedUserDto;
    }
    @Override
    public UserDto getUserById(Long userId) {
        Optional<User> optionalUser = userRepo.findById(userId);
        User user= optionalUser.get();
        return  UserMapper.mapToUserDto(user);
    }
    @Override
    public List<UserDto> getAllUser() {
        List<User> users= userRepo.findAll();
        return  users.stream().map(UserMapper::mapToUserDto)
                .collect(Collectors.toList());

    }
    @Override
    public UserDto updateUser(UserDto user) {
        User previousUser = userRepo.findById(user.getId()).get();
        previousUser.setFirstName(user.getFirstName());
        previousUser.setLastName(user.getLastName());
        previousUser.setEmail(user.getEmail());
        User updateUser = userRepo.save(previousUser);
        return UserMapper.mapToUserDto(updateUser);
    }
    @Override
    public void deleteUser(Long userId) {
        userRepo.deleteById(userId);
    }
}
