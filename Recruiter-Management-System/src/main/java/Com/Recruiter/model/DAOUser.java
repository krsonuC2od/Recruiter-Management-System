package Com.Recruiter.model;
import java.util.Set;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.JoinTable;
	import javax.persistence.ManyToMany;
	import javax.persistence.Table;
	import javax.persistence.Transient;

	import lombok.Getter;
	import lombok.NoArgsConstructor;
	import lombok.Setter;

	@Entity
	@Table(name = "user")
	@Getter
	@Setter
	@NoArgsConstructor
	public class DAOUser {

		@Transient
		private String token;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		@Column
		private String username;
		@Column
		private String password;
		@ManyToMany
	    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
		private Set < Role > roles;
	}

