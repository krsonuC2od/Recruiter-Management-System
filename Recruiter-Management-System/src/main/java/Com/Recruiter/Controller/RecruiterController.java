package Com.Recruiter.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Com.Recruiter.Service.RecruiterService;
import Com.Recruiter.model.Recruiter;

@RestController
@RequestMapping("/api/recruiters")
public class RecruiterController {
	
	private RecruiterService recruiterService;

	public RecruiterController(RecruiterService recruiterService) {
		super();
		this.recruiterService = recruiterService;
	}
	
	//build create Recruiter REST API
	@PostMapping()
	public ResponseEntity<Recruiter>saveRecruiter(@RequestBody Recruiter recruiter){
		return new ResponseEntity<Recruiter>(recruiterService.saveRecruiter(recruiter), HttpStatus.CREATED);
		
	}
	
	// build all Recruiter REST API
	@GetMapping
	public List<Recruiter>getAllRecruiter(){
		return recruiterService.getAllRecruiter();
	}

	
	//build get Recruiter by Id REST API
	@GetMapping("{id}")
	public ResponseEntity<Recruiter>getEmployeeById(@PathVariable("id")long recruiterId){
		return new ResponseEntity<Recruiter>(recruiterService.getRecruiterById(recruiterId), HttpStatus.OK);
		
	}
	//build update Recruiter REST API
	@PutMapping("{id}")
	public ResponseEntity<Recruiter>updateRecruiter(@PathVariable("id") long id, @RequestBody Recruiter recruiter){
		
		return new ResponseEntity<Recruiter>(recruiterService.updateRecruiter(recruiter, id), HttpStatus.OK);
	}
	
	//build delete recuiter REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteRecruiter(@PathVariable("id") long id){
		recruiterService.deleteRecuiter(id);
		return new ResponseEntity<String>("Recruiter deleted successfully!.",HttpStatus.OK);
		
	}
}
