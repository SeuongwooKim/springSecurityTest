package org.example.springsecurity.service;

import org.example.springsecurity.dto.JoinDTO;
import org.springframework.stereotype.Service;

public interface JoinService {

    public boolean join(JoinDTO joinDTO);

}
