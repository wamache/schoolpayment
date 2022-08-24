package com.schoolfeespayment.dependants;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="dependant")
public class Dependant {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    //private Long student_id;

    private String regNumber;

    private String dependantName;

    private String schoolName;







}
