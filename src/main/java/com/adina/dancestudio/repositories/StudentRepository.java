package com.adina.dancestudio.repositories;

import com.adina.dancestudio.models.entities.Reservation;
import com.adina.dancestudio.models.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> getStudentByStudentId(Long studentId);
    List<Student> findByFirstName(String firstName);
    List<Student> findByLastName(String lastName);
    List<Student> findByAge(Integer age);
    List<Student> findByPhoneNumber(Integer phoneNumber);
    List<Student> findByGender(String gender);
    List<Student> findByAccountPassword(String accountPassword);


    @Query("SELECT s FROM students s WHERE s.firstName = :firstName")
    List<Student> findByFirstNameJPQL(String firstName);
    @Query("SELECT s FROM students s WHERE s.lastName = :lastName")
    List<Student> findByLastNameJPQL(String lastName);
    @Query("SELECT s FROM students s WHERE s.age = :age")
    List<Student> findByAgeJPQL(Integer age);
    @Query("SELECT s FROM students s WHERE s.phoneNumber = :phoneNumber")
    List<Student> findByPhoneNumberJPQL(Integer phoneNumber);
    @Query("SELECT s FROM students s WHERE s.gender = :gender")
    List<Student> findByGenderJPQL(String gender);
    @Query("SELECT s FROM students s WHERE s.accountPassword = :accountPassword")
    List<Student> findByAccountPasswordJPQL(String accountPassword);

}
