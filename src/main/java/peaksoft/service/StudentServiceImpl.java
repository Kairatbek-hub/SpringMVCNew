package peaksoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.StudentDao;
import peaksoft.entity.Student;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

    private final StudentDao studentDao;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void saveStudent(Long id, Student student) {
        studentDao.saveStudent(id,student);
    }

    @Override
    public void updateStudent(Long id,Student student) {
        studentDao.updateStudent(id,student);
    }

    @Override
    public List<Student> getAllStudents(Long id) {
        return studentDao.getAllStudents(id);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentDao.getStudentById(id);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentDao.deleteStudentById(id);
    }

    @Override
    public void assignStudentToCourse(Long studentId, Long courseId) {
        studentDao.assignStudentToCourse(studentId,courseId);
    }

    @Override
    public List<Student> countOfStudents(Long id) {
        return studentDao.countOfStudents(id);
    }



}
