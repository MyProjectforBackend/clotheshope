package com.shop.ClotheShop.service;

import java.util.List;
import java.util.stream.Collectors;

import com.shop.ClotheShop.domain.User;
import org.springframework.stereotype.Service;

import com.shop.ClotheShop.dto.UserDTO;
import com.shop.ClotheShop.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public UserDTO getUserById(Integer id) {
        return userRepository.findById(id).map(this::toDTO).orElse(null);
    }

    public UserDTO createUser(UserDTO dto) {
        User user = toEntity(dto);
        return toDTO(userRepository.save(user));
    }

    public UserDTO updateUser(Integer id, UserDTO dto) {
        return userRepository.findById(id).map(existing -> {
            existing.setFullName(dto.getFirstName());
            existing.setLastName(dto.getLastName());
            existing.setGmail(dto.getGmail());
            existing.setPassword(dto.getPassword());
            existing.setPhone(dto.getPhone());
            return toDTO(userRepository.save(existing));
        }).orElse(null);
    }

    private UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setUsername(user.getFirstName() + "." + user.getLastName());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setGmail(user.getGmail());
        dto.setPassword(user.getPassword());
        dto.setRole("USER");
        dto.setPhone(user.getPhone());
        return dto;
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    private User toEntity(UserDTO dto) {
        User user = new User();
        user.setFullName(dto.getFirstName() + " " + dto.getLastName());
        user.setGmail(dto.getGmail());
        user.setPassword(dto.getPassword());
        user.setPhone(dto.getPhone());
        return user;
    }
}
