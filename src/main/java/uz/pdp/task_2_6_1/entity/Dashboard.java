package uz.pdp.task_2_6_1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data@AllArgsConstructor@NoArgsConstructor@Entity
public class Dashboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany
    private List<Simkarta> simcards;

    @OneToMany
    private List<Tarif> tariflar;

    @OneToMany
    private List<Paketlar> paketlar;

    @OneToMany
    private List<Xizmatlar> xizmatlar;
 }
