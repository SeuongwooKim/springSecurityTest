package org.example.springsecurity.controller;

import org.example.springsecurity.dto.JoinDTO;
import org.example.springsecurity.service.JoinService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/join")
public class JoinController {

    private final JoinService joinService;

    public JoinController(JoinService joinService) {
        this.joinService = joinService;
    }

    @PostMapping()
    public Boolean join(@RequestBody JoinDTO joinDTO) {
        Boolean join = joinService.join(joinDTO);
        if (join) {
            return true;
        } else {
            return false;
        }
    }

}
