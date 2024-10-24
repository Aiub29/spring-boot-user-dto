package com.aiub.UserMangement_Spring_Boot.impl;

import com.aiub.UserMangement_Spring_Boot.dto.UserDto;
import com.aiub.UserMangement_Spring_Boot.entity.User;
import com.aiub.UserMangement_Spring_Boot.mapper.UserMapper;
import com.aiub.UserMangement_Spring_Boot.repo.UserRepo;
import com.aiub.UserMangement_Spring_Boot.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;
    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user =modelMapper.map(userDto,User.class);
        User savedUser=userRepo.save(user);
     UserDto savedUserDto =modelMapper.map(savedUser,UserDto.class);
        return  savedUserDto;

    }
    @Override
    public UserDto getUserById(Long userId) {
        Optional<User> optionalUser = userRepo.findById(userId);
        User user= optionalUser.get();
       return  modelMapper.map(user,UserDto.class);
    }
    @Override
    public List<UserDto> getAllUser() {
        List<User> users= userRepo.findAll();
//        return  users.stream().map(UserMapper::mapToUserDto)
//                .collect(Collectors.toList());

        return  users.stream().map((user -> modelMapper.map(user,UserDto.class)))
              .collect(Collectors.toList());
    }
    @Override
    public UserDto updateUser(UserDto user) {
        User previousUser = userRepo.findById(user.getId()).get();
        previousUser.setFirstName(user.getFirstName());
        previousUser.setLastName(user.getLastName());
        previousUser.setEmail(user.getEmail());
        User updateUser = userRepo.save(previousUser);
        //return UserMapper.mapToUserDto(updateUser);

        return modelMapper.map(updateUser, UserDto.class);
    }
    @Override
    public void deleteUser(Long userId) {
        userRepo.deleteById(userId);
    }
}
