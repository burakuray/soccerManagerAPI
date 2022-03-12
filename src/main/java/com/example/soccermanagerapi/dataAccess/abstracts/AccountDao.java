package com.example.soccermanagerapi.dataAccess.abstracts;

import com.example.soccermanagerapi.entities.concretes.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao extends JpaRepository<Account,Integer> {
    Account getByUsername(String accountName);
    Account getByUsernameAndEmail(String accountName, String accountEmail);
}
