package Com.Recruiter.Student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Com.Recruiter.Student.Service.StudentService;

public interface StudentRepo extends JpaRepository<StudentService, Long> {

}
