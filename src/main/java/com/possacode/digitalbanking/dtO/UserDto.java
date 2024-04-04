package com.possacode.digitalbanking.dtO;

import jakarta.validation.constraints.*;
import com.possacode.digitalbanking.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserDto {

    private Integer id;


    @NotEmpty(message = "Le prenom ne doit pas etre vide")
    @NotBlank(message = "Le prenom ne doit pas etre vide")
    private String firstname;


    @NotEmpty(message = "Le nom ne doit pas etre vide")
    @NotBlank(message = "Le nom ne doit pas etre vide")
    private String lastname;


    @NotEmpty(message = "L'email ne doit pas etre vide")
    @NotBlank(message = "L'email ne doit pas etre vide")
    @Email(message = "L'email n'est conforme")
    private String email;


    @NotEmpty(message = "Le mot de passe ne doit pas etre vide")
    @NotBlank(message = "Le mot de passe ne doit pas etre vide")
    @Size(min = 8, max = 16, message = "Le mot de passe doit etre entre 8 et 16 caracteres")
    private String password;
    private String iban;
    private boolean active;

    public static UserDto fromEntity(User user){
        return UserDto.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .iban(user.getAccount() == null ? "" : user.getAccount().getIban())
                .active(user.isActive())
                .password(user.getPasswrod())
                .build();
    }

    public static User toEntity(UserDto userDto){
        return User.builder()
                .id(userDto.getId())
                .firstname(userDto.getFirstname())
                .lastname(userDto.getLastname())
                .email(userDto.getEmail())
                .passwrod(userDto.getPassword())
                .build();
    }
}
