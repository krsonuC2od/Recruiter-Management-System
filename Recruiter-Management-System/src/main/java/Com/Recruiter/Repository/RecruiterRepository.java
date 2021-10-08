package Com.Recruiter.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Com.Recruiter.model.Recruiter;

public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {

}
