package site.orangefield.security01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import site.orangefield.security01.model.User;

// JpaRepository는 기본적인 CRUD 함수를 갖고 있다
// JpaRep~를 상속했기 때문에 어노테이션을 붙이지 않아도 IoC 된다
public interface UserRepository extends JpaRepository<User, Integer> {

    // findBy + JPA Query Method
    public User findByUsername(String username);
}
