package site.orangefield.security01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity // Security 활성화, 스프링 시큐리티 필터가 스프링 필터 체인에 등록이 된다
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Security는 비밀번호를 암호화해야 로그인 할 수 있다.
    @Bean // 해당 메서드의 리턴되는 오브젝트를 IoC로 등록
    public BCryptPasswordEncoder encodePwd() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/user/**").authenticated() // 인증이 필요
                .antMatchers("/manager/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')") // 권한이 있어야
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll() // 위의 주소가 아니라면 모든 권한이 있음
                .and()
                .formLogin()
                .loginPage("/loginForm")
                .loginProcessingUrl("/login") // 시큐리티가 자격증명을 확인할 URL 지정
                .defaultSuccessUrl("/");
    }
}
