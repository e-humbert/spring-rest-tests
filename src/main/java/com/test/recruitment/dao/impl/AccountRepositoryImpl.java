package com.test.recruitment.dao.impl;

import com.test.recruitment.dao.AccountRepository;
import com.test.recruitment.entity.Account;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of {@link AccountRepository}
 */
@Repository
public class AccountRepositoryImpl implements AccountRepository, InitializingBean {

    private List<Account> accounts;

    @Override
    public void afterPropertiesSet() throws Exception {
        accounts = new ArrayList<>();

        {
            Account account = new Account();
            account.setId("1");
            account.setCreationDate(new Date());
            account.setActive(true);
            account.setType("SAVING");
            account.setNumber("01000251215");
            account.setBalance(BigDecimal.valueOf(4210.42));
            accounts.add(account);
        }
        {
            Account account = new Account();
            account.setId("2");
            account.setCreationDate(new Date());
            account.setActive(false);
            account.setType("CURRENT");
            account.setNumber("01000251216");
            account.setBalance(BigDecimal.valueOf(25.12));
            accounts.add(account);
        }
    }

    @Override
    public Page<Account> findAll(Pageable pageable) {
        return new PageImpl<>(accounts);
    }

    @Override
    public Optional<Account> findById(String accountId) {
        return accounts.stream().filter(account -> account.getId().equals(accountId))
            .findFirst();
    }

    @Override
    public boolean exists(String accountId) {
        return accounts.stream().anyMatch(account -> account.getId().equals(accountId));
    }

}
