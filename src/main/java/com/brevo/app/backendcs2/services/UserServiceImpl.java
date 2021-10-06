package com.brevo.app.backendcs2.services;

import java.util.UUID;

import com.brevo.app.backendcs2.UserRepository;
import com.brevo.app.backendcs2.dto.UserDTO;
import com.brevo.app.backendcs2.entities.UserEntity;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    UserRepository userRepository;
  
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        if(userRepository.findUserByEmail(userDTO.getEmail()) !=null)
           throw new RuntimeException("El Email ya existe");
        
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDTO, userEntity);
        userEntity.setEncryptedPassword("testpassword");
        UUID userId = UUID.randomUUID();
        userEntity.setUserId(userId.toString());

        UserEntity storedUserdetail = userRepository.save(userEntity);
        UserDTO userToReturn = new UserDTO();
        BeanUtils.copyProperties(storedUserdetail, userToReturn);
        
        return userToReturn;
    }
}
