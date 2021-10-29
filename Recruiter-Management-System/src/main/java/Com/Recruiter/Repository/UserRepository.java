package Com.Recruiter.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Com.Recruiter.model.DAOUser;

@Repository
	public interface UserRepository  extends JpaRepository<DAOUser, Long> {
		DAOUser findByUsername(String username);

	}
