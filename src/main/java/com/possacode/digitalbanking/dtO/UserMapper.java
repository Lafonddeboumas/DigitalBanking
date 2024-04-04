package com.possacode.digitalbanking.dtO;

public class UserMapper{

    public static UserDto fromEntity(User user){
        return new UserDto(
                user.id(),
                user.firstname(),
                user.firstname()
        );
    }

    public static User toEntity(UserDto userDto){
        return new User(
                userDto.id(),
                userDto.firstname(),
                userDto.lastnmae()
        );
    }


    public record  UserDto(String id, String firstname, String lastnmae){}

    public record User(String id,  String firstname, String lastnmae){}
}
