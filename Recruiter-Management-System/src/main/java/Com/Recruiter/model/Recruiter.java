package Com.Recruiter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="recruiter")
public class Recruiter {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	
	@Column(name ="name",nullable = false)
	private String name;
	@Column(name ="email",nullable = false)
	private String email;
	@Column(name ="password",nullable = false)
	private String password;
	@Column(name ="company",nullable = false)
	private String company;

}
