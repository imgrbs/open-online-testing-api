package online.testing.user.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import online.testing.user.model.user.impl.UserImpl;

@Repository
public interface UserRepository extends MongoRepository<UserImpl, String> {
    Optional<UserImpl> findByEmail(String email);

    Optional<UserImpl> findById(String id);

    Boolean existsByEmail(String email);
}
