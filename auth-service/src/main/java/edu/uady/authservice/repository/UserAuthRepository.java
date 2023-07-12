package edu.uady.authservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uady.authservice.entity.UserAuth;

public interface UserAuthRepository extends JpaRepository<UserAuth, Integer> {
	Optional<UserAuth> findByUserName (String userName);

}
