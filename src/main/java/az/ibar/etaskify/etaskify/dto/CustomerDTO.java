package az.ibar.etaskify.etaskify.dto;


import lombok.Data;

@Data
public class CustomerDTO {

    private String organizationName;
    private String phoneNumber;
    private String address;
    private String userName;
    private String email;
    private String password;
    private Long id;

}
