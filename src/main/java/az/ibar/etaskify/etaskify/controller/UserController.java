package az.ibar.etaskify.etaskify.controller;


import az.ibar.etaskify.etaskify.dto.BaseResponse;
import az.ibar.etaskify.etaskify.dto.SignInDTO;
import az.ibar.etaskify.etaskify.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping(value = "/signin")
    public BaseResponse signIn(@RequestBody SignInDTO signInDTO){
        return userService.signIn(signInDTO);
    }


}
