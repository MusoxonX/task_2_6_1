package uz.pdp.task_2_6_1.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SotishDto {
    private String firstName;
    private String lastName;
    private String passportNumber;
    private Integer simkartaId;
}
