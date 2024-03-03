package com.adina.dancestudio.repositories;
import com.adina.dancestudio.models.entities.Subscription;
import com.adina.dancestudio.models.entities.Teacher;
import com.adina.dancestudio.models.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> getByTeacherId(Long teacherId);
    List<Teacher> findByTeacherName(String teacherName);
    @Query("SELECT t FROM teachers t WHERE t.teacherName = :teacherName")
    List<Subscription> findByTeacherNameJPQL(String teacherName);

}
