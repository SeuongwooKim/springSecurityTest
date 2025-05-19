package org.example.springsecurity.service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.example.springsecurity.dto.JoinDTO;
import org.example.springsecurity.entity.UserEntity;
import org.example.springsecurity.repository.UserRepository;
import org.example.springsecurity.service.JoinService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JoinServiceImpl implements JoinService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public JoinServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public boolean join(JoinDTO joinDTO) {

        Boolean userExist = userRepository.existsByUsername(joinDTO.getUsername());
        if (userExist) {
            log.error("Already exists username " + joinDTO.getUsername());
            return false;
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(joinDTO.getUsername());
        userEntity.setPassword(bCryptPasswordEncoder.encode(joinDTO.getPassword()));
        userEntity.setRole("ROLE_ADMIN");
        userRepository.save(userEntity);

        return true;
    }
}
