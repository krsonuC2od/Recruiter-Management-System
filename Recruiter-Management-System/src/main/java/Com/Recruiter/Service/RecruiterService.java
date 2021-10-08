package Com.Recruiter.Service;

import java.util.List;

import Com.Recruiter.model.Recruiter;

public interface RecruiterService {
	Recruiter saveRecruiter(Recruiter recruiter);
	List<Recruiter> getAllRecruiter();
	Recruiter getRecruiterById(long id);
	Recruiter updateRecruiter(Recruiter recruiter, long id);
	void deleteRecuiter(long id);

}
