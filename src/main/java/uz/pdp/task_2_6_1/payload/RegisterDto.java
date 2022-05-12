package uz.pdp.task_2_6_1.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Email
    @NotNull
    private String email;

    @NotNull
    private String password;
}
