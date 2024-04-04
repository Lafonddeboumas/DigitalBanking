package com.possacode.digitalbanking.sevices;


import com.possacode.digitalbanking.dtO.TransactionDto;

import java.util.List;

public interface TransactionService extends AbstractService<TransactionDto>{

    List<TransactionDto> findAllByUserId(Integer id);
}
