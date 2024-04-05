package org.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDateTime;

@Entity
@Data
@Getter
@Setter
@Table(name="Shift_Model")
public class Shift {
    @Column(name="Shift_Id")
    @Id
    @GeneratedValue
    private int shiftId;
    @Column(name="Job_Description",nullable = false)
    private String shiftJobDescription;
    @Column(name="Start_Time",nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime shiftStartTime;
    @Column(name="End_Time",nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime shiftEndTime ;
    @Column(name="RequestedUserId")
    private int requestUser_id;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

}
