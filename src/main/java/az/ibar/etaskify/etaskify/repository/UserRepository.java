package az.ibar.etaskify.etaskify.repository;

import az.ibar.etaskify.etaskify.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity>findByUserNameAndPassword(String userName, String password);

}
