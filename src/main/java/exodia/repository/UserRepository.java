package exodia.repository;

import exodia.domain.entities.User;

public interface UserRepository extends GenericRepository<User, String> {

    User findUserByUsername(String username);
    
}
