package org.ubt.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ubt.profile.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
