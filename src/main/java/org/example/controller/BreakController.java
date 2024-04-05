package org.example.controller;

import org.example.Repository.BreakRepository;
import org.example.model.Break;
import org.example.service.BreakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/break")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class BreakController {
    @Autowired
    BreakService breakService;
    @PostMapping("/addBreak")
    public Break saveBreak(@RequestBody Break break1){
        return breakService.saveBreak(break1);
    }
}
