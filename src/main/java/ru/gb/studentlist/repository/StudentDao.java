package ru.gb.studentlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.studentlist.entity.Student;

import java.util.Optional;

public interface StudentDao extends JpaRepository<Student, Long> {

    Optional<Student> findStudentById(Long id);
    void deleteStudentById(Long id);
}
