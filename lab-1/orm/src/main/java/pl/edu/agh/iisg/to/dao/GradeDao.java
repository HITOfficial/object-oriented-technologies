package pl.edu.agh.iisg.to.dao;

import pl.edu.agh.iisg.to.model.Course;
import pl.edu.agh.iisg.to.model.Grade;
import pl.edu.agh.iisg.to.model.Student;

import javax.persistence.PersistenceException;

public class GradeDao extends GenericDao<Grade> {

    public boolean gradeStudent(final Student student, final Course course, final float grade) {
        //TODO implement

        Grade gradeToAdd = new Grade(student,course,grade);
        try {
            save(gradeToAdd);

        } catch (PersistenceException e){
            e.printStackTrace();
        }

        student.gradeSet().add(gradeToAdd);
        course.gradeSet().add(gradeToAdd);


        CourseDao courseDao = new CourseDao();
        StudentDao studentDao = new StudentDao();

        try {
            courseDao.update(course);
            studentDao.update(student);
            return  true;
        } catch (PersistenceException e) {
            e.printStackTrace();
        }

        return false;
    }


}
