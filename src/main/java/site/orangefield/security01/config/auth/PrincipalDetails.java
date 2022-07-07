package site.orangefield.security01.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import site.orangefield.security01.model.User;

// /login 요청이 오면 Security가 로그인 진행
// 로그인 진행이 완료되면 시큐리티 Session을 만들어준다 (Security ContextHolder)
// 오브젝트의 타입은 Authentication 타입 객체
// 그 안의 User 오브젝트의 타입은 UserDetails 타입 객체

// Security Session => Authentication => UserDetails
public class PrincipalDetails implements UserDetails {

    private User user; // Composition

    public PrincipalDetails(User user) {
        this.user = user;
    }

    // 해당 User의 Role을 리턴
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {

            @Override
            public String getAuthority() {
                return user.getRole();
            }

        });
        return collect;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        // 1년동안 로그인을 안하면 휴면계정으로 변환
        // (현재시간 - 로그인시간)이 1년을 초과하면 return false;
        return true;
    }

}
