package com.wallet.main.dtos;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Data
public class UserDto {

    private Long id;
    @Max(3)
    @Min(50)
    @NotBlank(message = "O nome deve conter entre 3 e 50 caracteres")
    private String name;
    @Email(message = "E-Mail inválido")
    private String email;
    @Max(6)
    @NotBlank(message = "A senha deve conter no minímo 6 caracteres")
    private String password;
}
