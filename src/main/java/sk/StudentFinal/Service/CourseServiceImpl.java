package sk.StudentFinal.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.StudentFinal.dao.CourseRepository;
import sk.StudentFinal.model.Course;
import sk.StudentFinal.model.Student;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements GenericService<Course, String> {

    private CourseRepository courseRepo;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepo){this.courseRepo = courseRepo;}

    @Override
    public Optional<Course> findById(String id) {
        Optional<Course> result = courseRepo.findById(id);
        Course course;

        if (result.isPresent()){
            course = result.get();
        } else {
            throw new RuntimeException("Did not find course id - " + id);
        }

        return Optional.of(course);
    }

    @Override
    public List<Course> findAll() {
        return courseRepo.findAll();
    }

    @Override
    public void save(Course course) {
        courseRepo.save(course);
    }

    @Override
    public void deleteById(String id) {
        courseRepo.deleteById(id);
    }
}

