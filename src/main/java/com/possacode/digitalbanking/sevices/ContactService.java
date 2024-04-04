package com.possacode.digitalbanking.sevices;


import com.possacode.digitalbanking.dtO.ContactDto;

import java.util.List;

public interface ContactService extends AbstractService<ContactDto>{

    List< ContactDto> findAllByUserId(Integer id);
}
