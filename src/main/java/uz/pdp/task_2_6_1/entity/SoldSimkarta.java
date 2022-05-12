package uz.pdp.task_2_6_1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SoldSimkarta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    @Column(unique = true,nullable = false)
    private String passportNumber;

    @OneToOne
    private Simkarta simkarta;
}
