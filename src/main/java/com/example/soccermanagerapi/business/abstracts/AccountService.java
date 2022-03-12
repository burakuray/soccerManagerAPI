package com.example.soccermanagerapi.business.abstracts;

import com.example.soccermanagerapi.core.utilities.results.DataResult;
import com.example.soccermanagerapi.core.utilities.results.Result;
import com.example.soccermanagerapi.entities.concretes.Account;

import java.util.List;

public interface AccountService {
    DataResult<List<Account>> getAll();
    Result createAccount(Account account);
}
