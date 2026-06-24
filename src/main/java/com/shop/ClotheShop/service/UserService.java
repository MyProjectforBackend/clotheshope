package com.shop.ClotheShop.service;

import java.util.List;
import java.util.stream.Collectors;

import com.shop.ClotheShop.domain.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shop.ClotheShop.dto.UserDTO;
import com.shop.ClotheShop.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Integer id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        return toDTO(user);
    }

    public UserDTO createUser(UserDTO dto) {

        User user = toEntity(dto);

        user.setPassword(
                passwordEncoder.encode(dto.getPassword()));

        return toDTO(userRepository.save(user));
    }

    public UserDTO updateUser(Integer id, UserDTO dto) {

        User existing = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        existing.setFirstName(dto.getFirstName());
        existing.setLastName(dto.getLastName());
        existing.setFullName(dto.getFirstName() + " " + dto.getLastName());
        existing.setGmail(dto.getGmail());
        existing.setPhone(dto.getPhone());

        // update password only if sent
        if (dto.getPassword() != null && !dto.getPassword().isEmpty()) {
            existing.setPassword(
                    passwordEncoder.encode(dto.getPassword()));
        }

        return toDTO(userRepository.save(existing));
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    private UserDTO toDTO(User user) {

        UserDTO dto = new UserDTO();

        dto.setId(user.getId());

        dto.setUsername(
                user.getFirstName() + "." + user.getLastName());

        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setGmail(user.getGmail());
        dto.setPhone(user.getPhone());
        dto.setRole("USER");

        return dto;
    }

    private User toEntity(UserDTO dto) {

        User user = new User();

        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setFullName(dto.getFirstName() + " " + dto.getLastName());
        user.setGmail(dto.getGmail());
        user.setPhone(dto.getPhone());

        // password handled

        return user;
    }
}