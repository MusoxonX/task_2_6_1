package uz.pdp.task_2_6_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.task_2_6_1.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByEmail(String email);
}
