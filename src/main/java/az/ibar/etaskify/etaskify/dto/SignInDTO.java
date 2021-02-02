package az.ibar.etaskify.etaskify.dto;

import lombok.Data;

import javax.validation.constraints.Size;


@Data
public class SignInDTO {
    private String userName;
    @Size(min = 6)
    private String password;


}
