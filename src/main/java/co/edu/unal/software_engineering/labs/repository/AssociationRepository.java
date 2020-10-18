package co.edu.unal.software_engineering.labs.repository;

import co.edu.unal.software_engineering.labs.model.Association;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

//import antlr.collections.List;

@Repository
public interface AssociationRepository extends JpaRepository<Association, Integer>{
    @Query( value = "SELECT * FROM Association WHERE user_id = ?1", nativeQuery = true)    
    List<Association> findByuser(Integer user_id);
}
