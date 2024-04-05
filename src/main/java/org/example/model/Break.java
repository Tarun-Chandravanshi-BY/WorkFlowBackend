package org.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name="Break_Model")
public class Break {
    @Id
    @GeneratedValue
    @Column(name="Break_Id")
    private int breakId;
    @Column(name="Start_Time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime breakStartTime;
    @Column(name="End_Time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime breakEndTime;
    @Column(name="Meal_Break")
    private boolean mealBreak;
    @ManyToOne
    @JoinColumn(name="Shift_id")
    private Shift shift;


}
