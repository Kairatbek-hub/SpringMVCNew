package peaksoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.InstructorDao;
import peaksoft.entity.Instructor;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class InstructorServiceImpl implements InstructorService {

    private final InstructorDao instructorDao;

    @Autowired
    public InstructorServiceImpl(InstructorDao instructorDao) {
        this.instructorDao = instructorDao;
    }

    @Override
    public void saveInstructor(Long id,Instructor instructor) {
        instructorDao.saveInstructor(id,instructor);
    }

    @Override
    public void updateInstructor(Long id,Instructor instructor) {
        instructorDao.updateInstructor(id,instructor);
    }

    @Override
    public List<Instructor> getAllInstructor(Long id) {
        return instructorDao.getAllInstructor(id);
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorDao.getInstructorById(id);
    }

    @Override
    public void deleteInstructorById(Long id) {
        instructorDao.deleteInstructorById(id);
    }

    @Override
    public void assignInstructorToCourse(Long instructorId, Long courseId) {
        instructorDao.assignInstructorToCourse(instructorId,courseId);
    }
}
