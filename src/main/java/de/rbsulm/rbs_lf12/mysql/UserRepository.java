package de.rbsulm.rbs_lf12.mysql;

import de.rbsulm.rbs_lf12.model.User;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}