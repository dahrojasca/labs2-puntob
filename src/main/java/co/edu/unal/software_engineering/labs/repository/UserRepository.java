package co.edu.unal.software_engineering.labs.repository;

import co.edu.unal.software_engineering.labs.model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    @Query(value = "SELECT * FROM User WHERE Username = ?1", nativeQuery = true)
    User findById(String username);
}
