package Com.Recruiter.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Com.Recruiter.Service.RecruiterService;

public interface RecruiterRepo extends JpaRepository<RecruiterService, Long> {

}
