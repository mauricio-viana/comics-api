package br.com.api.repository;

import br.com.api.models.UserApi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <UserApi, Long>{

    Optional<UserApi> findByEmail(String email);
}
