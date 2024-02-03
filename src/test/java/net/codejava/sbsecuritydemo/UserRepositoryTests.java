package net.codejava.sbsecuritydemo;

import net.codejava.sbsecuritydemo.entities.User;
import net.codejava.sbsecuritydemo.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repo;

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Test
    public void testCreateUser1() {
        User user = new User();
        user.setUsername("ruvi");
        user.setPassword(passwordEncoder().encode("123"));
        user.setFirstName("Ruvindu");
        user.setLastName("Madhushanka");

        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(user.getUsername()).isEqualTo(existUser.getUsername());
    }

    @Test
    public void testCreateUser2() {
        User user = new User();
        user.setUsername("rmsk");
        user.setPassword(passwordEncoder().encode("456"));
        user.setFirstName("Madhushanka");
        user.setLastName("Sisira Kumara");

        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(user.getUsername()).isEqualTo(existUser.getUsername());
    }

}
