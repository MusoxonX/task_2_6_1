package uz.pdp.task_2_6_1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Xizmatlar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(nullable = false)
    private String haqida;

    @Column(nullable = false)
    private String turi;

    private boolean active=false;
}
