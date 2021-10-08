package Com.Recruiter.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Com.Recruiter.Repository.RecruiterRepository;
import Com.Recruiter.Service.RecruiterService;
import Com.Recruiter.exception.ResourceNotFoundException;
import Com.Recruiter.model.Recruiter;
@Service
public class RecruiterServiceImpl implements RecruiterService{

	
	private RecruiterRepository recruiterRepository;
	
	
	public RecruiterServiceImpl(RecruiterRepository recruiterRepository) {
		super();
		this.recruiterRepository = recruiterRepository;
	}


	@Override
	public Recruiter saveRecruiter(Recruiter recruiter) {
		
		return recruiterRepository.save(recruiter);
	}


	@Override
	public List<Recruiter> getAllRecruiter() {
		return recruiterRepository.findAll();	}


	@Override
	public Recruiter getRecruiterById(long id) {
	//	Optional<Recruiter>  recruiter = recruiterRepository.findById(id);
	//	if (recruiter.isPresent()) {
		//	return recruiter.get();
			
	//	}else {
		//	throw new ResourceNotFoundException("Recruiter"," Id", id);
	//	}
		
		return recruiterRepository.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("Recruiter", "Id", id));
	}


	@Override
	public Recruiter updateRecruiter(Recruiter recruiter, long id) {
		Recruiter existingRecruiter = recruiterRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Recruiter","Id", id));
		
		existingRecruiter.setCompany(recruiter.getCompany());
		existingRecruiter.setEmail(recruiter.getEmail());
		existingRecruiter.setName(recruiter.getName());
		existingRecruiter.setPassword(recruiter.getPassword());
		
		recruiterRepository.save(existingRecruiter);
		
				
		return existingRecruiter;
	}


	@Override
	public void deleteRecuiter(long id) {
		recruiterRepository.findById(id).orElseThrow(( )-> new ResourceNotFoundException("Recruiter", "Id", id));
		recruiterRepository.deleteById(id);
		
	}

}
