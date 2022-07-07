package site.orangefield.security01.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import site.orangefield.security01.model.User;
import site.orangefield.security01.repository.UserRepository;

/**
 * Security Session - Authentication - UserDetails
 */

// loginProcessiongUrl("/login")
// /login 요청이 오면 자동으로 UserDetailsService 타입으로 IoC 되어 있는 loadUserByUsername 함수 실행
@Service
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username : " + username);
        User userEntity = userRepository.findByUsername(username);
        if (userEntity != null) {
            return new PrincipalDetails(userEntity); // UserDetails 타입으로 Authentication에 쏙 들어감
        }
        return null;
    }
}
