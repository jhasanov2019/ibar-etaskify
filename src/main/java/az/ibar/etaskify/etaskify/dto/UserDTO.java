package az.ibar.etaskify.etaskify.dto;

import az.ibar.etaskify.etaskify.enums.UserRole;
import lombok.Data;

@Data
public class UserDTO {

    private String name;
    private String surname;
    private String email;
    private String password;
    private UserRole role;
    private Long id;
    private Long customerId;


}
