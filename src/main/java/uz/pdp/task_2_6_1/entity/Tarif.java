package uz.pdp.task_2_6_1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tarif {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private String tarifHaqida;

    @NotNull
    private double narxi;

    @NotNull
    private Date expireDate;

    private boolean active = false;
}