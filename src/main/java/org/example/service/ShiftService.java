package org.example.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.model.User;
import org.example.Repository.ShiftRepository;
import org.example.Repository.UserRepository;
import org.example.model.Shift;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftService {
    @Autowired
    ShiftRepository shiftRepository;

    @Autowired
    UserRepository userRepository;

    public Shift addShift(Shift shift) {
        return shiftRepository.save(shift);
    }

    public Shift assigningShift(Shift shift, int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
        shift.setUser(user);
        return shiftRepository.save(shift);
    }

    public String requestshift(Shift shift, int userId) {
        if (isShiftOverlap(shift, userId)) {
            throw new IllegalArgumentException("Please select another shift as the requested one overlaps with a previously assigned shift.");
        }
        shift.setRequestUser_id(userId);
        shiftRepository.save(shift);
        return "shift request sent succesfully";
    }

    public List<Shift> getAllShifts() {
        return shiftRepository.findAll();
    }

    public List<Shift> getAvailableShifts() {
        return shiftRepository.getAvailableShifts();
    }

    public List<Shift> getshiftsAssignedtoEmployee(int userId) {
        return shiftRepository.getshiftsAssignedtoEmployee(userId);
    }

    public boolean isShiftOverlap(Shift requestedShift, int userId) {
        List<Shift> assignedShifts = getshiftsAssignedtoEmployee(userId);

        for (Shift assignedShift : assignedShifts) {
            if ((requestedShift.getShiftEndTime().isAfter(assignedShift.getShiftStartTime()) &&
                    requestedShift.getShiftEndTime().isBefore(assignedShift.getShiftEndTime())) || (requestedShift.getShiftStartTime().isAfter(assignedShift.getShiftStartTime()) &&
                    requestedShift.getShiftStartTime().isBefore(assignedShift.getShiftEndTime())) || (requestedShift.getShiftStartTime().isBefore(assignedShift.getShiftStartTime()) &&
                    requestedShift.getShiftEndTime().isAfter(assignedShift.getShiftEndTime())) || (requestedShift.getShiftStartTime().isEqual(assignedShift.getShiftStartTime()) ||
                    requestedShift.getShiftEndTime().isEqual(assignedShift.getShiftEndTime()))) {
                // Shifts overlap
                return true;
            }
        }
        return false;
    }
}

