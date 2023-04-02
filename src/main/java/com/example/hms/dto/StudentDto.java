package com.example.hms.dto;

import com.example.hms.entity.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class StudentDto implements SuperDto{

    private String student_id;
    private String name;
    private String address;
    private String contact_no;
    private String dob;
    private String gender;
   @ToString.Exclude
   private final List<Reservation> reservationList = new ArrayList<>();
}
