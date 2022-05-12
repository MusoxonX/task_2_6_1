package uz.pdp.task_2_6_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.task_2_6_1.entity.Filial;

public interface FilialRepository extends JpaRepository<Filial,Integer> {
    boolean existsByName(String name);
}
