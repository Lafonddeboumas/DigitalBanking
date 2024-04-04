package com.possacode.digitalbanking.sevices;


import com.possacode.digitalbanking.dtO.UserDto;

public interface UserService extends AbstractService<UserDto>{

    Integer validateAccount(Integer id);

    Integer invalidateAccount(Integer id);
}
