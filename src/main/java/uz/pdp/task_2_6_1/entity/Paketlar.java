package uz.pdp.task_2_6_1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Paketlar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    private String name;

    private String turlari;

    private Date expireDate;
}
