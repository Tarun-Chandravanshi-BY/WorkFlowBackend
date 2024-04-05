package org.example.Repository;

import org.apache.catalina.User;
import org.example.model.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ShiftRepository  extends JpaRepository<Shift,Integer> {
    @Query("SELECT s FROM Shift s WHERE s.user IS NULL")
    List<Shift> getAvailableShifts();

    @Query("SELECT s FROM Shift s WHERE s.user.userId=:userId")
    List<Shift> getshiftsAssignedtoEmployee(@Param("userId") int userId);
}
