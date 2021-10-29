package Com.Recruiter.model;





	import java.util.Set;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.ManyToMany;

	import lombok.Getter;
	import lombok.NoArgsConstructor;
	import lombok.Setter;

	@Entity
	@Getter
	@Setter
	@NoArgsConstructor
	public class Role {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    @ManyToMany(mappedBy = "roles")
	    private Set < DAOUser > users;
	}

