package net.codejava.sbsecuritydemo.repository;

import net.codejava.sbsecuritydemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
