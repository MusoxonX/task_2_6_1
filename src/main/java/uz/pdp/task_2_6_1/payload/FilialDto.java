package uz.pdp.task_2_6_1.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilialDto {

    @NotNull
    private String name;

    @NotNull
    private Integer managerId;

    private Integer rahbarId;

    private List<Integer> xodimlarId;
}
