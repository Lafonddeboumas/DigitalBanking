package com.possacode.digitalbanking.sevices.impl;

import com.possacode.digitalbanking.dtO.AccountDto;
import com.possacode.digitalbanking.exceptions.OperationNonPermittedException;
import com.possacode.digitalbanking.models.Account;
import com.possacode.digitalbanking.repository.AccountRepository;
import com.possacode.digitalbanking.sevices.AccountService;
import com.possacode.digitalbanking.validator.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final ObjectsValidator<AccountDto> validator;

    @Override
    public Integer save(AccountDto dto) {
        // block account update -> iban cannot be changed
        /* if (dto.getId() != null) {
          throw new OperationNonPermittedException(
              "Account cannot be updated",
              "save account",
              "Account",
              "Update not permitted"
          );
        }*/
        validator.validate(dto);
        Account account = AccountDto.toEntity(dto);
        boolean userHasAlreadyAnAccount = accountRepository.findByUserId(account.getUser().getId()).isPresent();
        if (userHasAlreadyAnAccount && account.getUser().isActive()) {
            throw new OperationNonPermittedException(
                    "the selected user has already an active account",
                    "Create account",
                    "Account service",
                    "Account creation"
            );
        }
        // generate random IBAN when creating new account else do not update the IBAN
        if (dto.getId() == null) {
            account.setIban(generateRandomIban());
        }
        return accountRepository.save(account).getId();
    }

    @Override
    public List<AccountDto> findAll() {
        return accountRepository.findAll()
                .stream()
                .map(AccountDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto findById(Integer id) {
        return accountRepository.findById(id)
                .map(AccountDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("No Account found with the ID : " +id));
    }

    @Override
    public void delete(Integer id) {
        accountRepository.deleteById(id);
    }

    private String generateRandomIban() {
        // generate an iban
        String iban = Iban.random(CountryCode.DE).toFormattedString();

        // check if the iban already exists
        boolean ibanExists = accountRepository.findByIban(iban).isPresent();
        // if exists -> generate new random iban
        if (ibanExists) {
            generateRandomIban();
        }
        // if not exist -> return generated iban
        return iban;
    }
}
