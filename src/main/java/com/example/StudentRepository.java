package com.example;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
//	@Query("select s from Student s where s.approved = 0")
//	List<Student> ListApproved();
	List<Student> findByApprovedEquals(int a);
}
