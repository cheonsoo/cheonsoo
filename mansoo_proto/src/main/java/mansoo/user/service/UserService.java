package mansoo.user.service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Collection<GrantedAuthority> authorities = Arrays.asList((GrantedAuthority)new SimpleGrantedAuthority("ROLE_USER"));
		UserDetails userDetails = new User(username, "framework", true, false, false, false, authorities);
		
		return userDetails;
	}

}
