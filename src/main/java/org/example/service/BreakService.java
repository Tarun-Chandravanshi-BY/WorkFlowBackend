package org.example.service;

import org.example.Repository.BreakRepository;
import org.example.model.Break;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BreakService {
    @Autowired
    BreakRepository breakRepository;
    public Break saveBreak(Break break1){
        return breakRepository.save(break1);
    }

}
