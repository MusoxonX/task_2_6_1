package uz.pdp.task_2_6_1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SoldTarif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private SoldSimkarta soldSimkarta;

    @ManyToOne
    private Tarif tarif;
}
