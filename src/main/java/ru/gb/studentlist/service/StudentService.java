package ru.gb.studentlist.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.studentlist.entity.Student;
import ru.gb.studentlist.repository.StudentDao;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentDao studentDao;

    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return studentDao.findAll();
    }


    public Student save(Student student){
        if (student.getId() != null) {
            Optional<Student> studentFromDbOptional = studentDao.findById(student.getId());
            if (studentFromDbOptional.isPresent()) {
                Student studentFromDb = studentFromDbOptional.get();
                studentFromDb.setName(student.getName());
                studentFromDb.setAge(student.getAge());
                return studentDao.save(studentFromDb);
            }
        }
        return studentDao.save(student);
    }

    @Transactional(readOnly = true)
    public Student findById(Long id){
        return studentDao.findStudentById(id).get();
    }
    @Transactional
    public void deleteById(Long id){
        studentDao.deleteStudentById(id);
    }
}
