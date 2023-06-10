package com.example;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="student")
public class Student {
	@Id
	private String id;
	private String name;
	private LocalDate dob;
	private String department;
	private int approved;
}
