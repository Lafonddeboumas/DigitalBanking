package com.possacode.digitalbanking.dtO;


import com.possacode.digitalbanking.models.Adress;
import com.possacode.digitalbanking.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AdressDto {

    private Integer id;
    private String street;

    private Integer houseNumber;

    private Integer zipCode;

    private String city;

    private String country;
    private Integer userId;

    public static AdressDto fromEntity(Adress adress){
       return AdressDto.builder()
                .id(adress.getId())
                .street(adress.getStreet())
                .houseNumber(adress.getHouseNumber())
                .zipCode(adress.getZipCode())
                .city(adress.getCity())
                .country(adress.getCounty())
                .userId(adress.getUser().getId())
                .build();
    }

    public static Adress toEntity(AdressDto adressDto){
        return Adress.builder()
                .id(adressDto.getId())
                .street(adressDto.getStreet())
                .houseNumber(adressDto.getHouseNumber())
                .zipCode(adressDto.getZipCode())
                .city(adressDto.getCity())
                .county(adressDto.getCountry())
                .user(
                        User.builder()
                                .id(adressDto.getId())
                                .build()
                )
                .build();
    }
}
