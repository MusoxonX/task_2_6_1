package uz.pdp.task_2_6_1.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class XizmatDto {
    private String name;
    private String haqida;
    private String turi;
    private Integer simkartaId;
}
