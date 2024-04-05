package org.example.controller;

import org.example.model.Shift;
import org.example.model.User;
import org.example.service.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/shift")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class ShiftController {
    @Autowired
    ShiftService shiftService;

    @PostMapping("/assignShift")
    public Shift saveShift(@RequestBody Shift shift) {
        return shiftService.addShift(shift);
    }

    @PostMapping("/assignShift/{id}")
    public Shift assignShift(@RequestBody Shift shift, @PathVariable int id) {
        return shiftService.assigningShift(shift, id);
    }

    @PutMapping("/requestshift/{id}")
    public ResponseEntity<String> requestshift(@RequestBody Shift shift, @PathVariable int id) {
        try {
            shiftService.requestshift(shift, id);
            return ResponseEntity.ok("Shift request sent successfully");
        } catch (IllegalArgumentException e) {
            // Handle the exception and return an appropriate response
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/getavailableshifts")
    public List<Shift> getAvailableShifts() {
        return shiftService.getAvailableShifts();
    }

    @GetMapping("/getallshifts")
    public List<Shift> getAllShifts() {
        return shiftService.getAllShifts();
    }

    @GetMapping("/getshiftsAssignedtoEmployee/{userId}")
    public List<Shift> getshiftsAssignedtoEmployee(@PathVariable int userId) {
        return shiftService.getshiftsAssignedtoEmployee(userId);
    }

}
