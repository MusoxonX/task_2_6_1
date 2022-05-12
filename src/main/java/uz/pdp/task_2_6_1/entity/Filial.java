package uz.pdp.task_2_6_1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Filial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,unique = true)
    private String name;

    @ManyToOne(optional = false)
    private User manger;

    @ManyToOne
    private User rahbar;

    @OneToMany
    private List<User> xodimlar;
}