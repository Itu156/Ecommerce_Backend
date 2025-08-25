package za.ac.cput.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.ecommerce.domain.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Override
    User save(User user);

    @Override
    void delete(User user);

    @Override
    Optional<User> findById(String id);

    @Override
    List<User> findAll();

}
