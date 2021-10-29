package Com.Recruiter.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Com.Recruiter.Service.impl.CustomUserDetailsService;
import Com.Recruiter.config.JwtUtil;
import Com.Recruiter.model.DAOUser;

//import com.ray.empmgm.config.JwtUtil;
//import com.ray.empmgm.entity.DAOUser;
//import com.ray.empmgm.service.CustomUserDetailsService;


	
	@CrossOrigin("*")
	@RestController
	@RequestMapping("/api")
	public class AuthencaticationController {

		@Autowired
		private AuthenticationManager authenticationManager;

		@Autowired
		private CustomUserDetailsService userDetailsService;

		@Autowired
		private JwtUtil jwtUtil;

		// login perpose
		@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
		public ResponseEntity<?> createAuthenticationToken(@RequestBody DAOUser authenticationRequest)
				throws Exception {
			try {
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
						authenticationRequest.getUsername(), authenticationRequest.getPassword()));
			} catch (DisabledException e) {
				throw new Exception("USER_DISABLED", e);
			}
			catch (BadCredentialsException e) {
				throw new Exception("INVALID_CREDENTIALS", e);
			}
			
			UserDetails userdetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
			String token = jwtUtil.generateToken(userdetails);
			return ResponseEntity.ok(token);
		}
		
		// Adding user
		@RequestMapping(value = "/register", method = RequestMethod.POST)
		public ResponseEntity<?> saveUser(@RequestBody DAOUser user) throws Exception {
			return ResponseEntity.ok(userDetailsService.save(user));
		}
	}



