package com.example.soccermanagerapi.business.concretes;

import com.example.soccermanagerapi.business.abstracts.AccountService;
import com.example.soccermanagerapi.core.utilities.results.DataResult;
import com.example.soccermanagerapi.core.utilities.results.Result;
import com.example.soccermanagerapi.core.utilities.results.SuccessDataResult;
import com.example.soccermanagerapi.core.utilities.results.SuccessResult;
import com.example.soccermanagerapi.core.utilities.util.createRandomTeam;
import com.example.soccermanagerapi.dataAccess.abstracts.AccountDao;
import com.example.soccermanagerapi.dataAccess.abstracts.PlayerDao;
import com.example.soccermanagerapi.entities.concretes.Account;
import com.example.soccermanagerapi.entities.concretes.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountManager implements AccountService {

    private AccountDao accountDao;

    @Autowired
    private PlayerDao playerDao;

    @Autowired
    public AccountManager(AccountDao accountDao) {
        super();
        this.accountDao = accountDao;
    }

    @Override
    public DataResult<List<Account>> getAll() {
        return new SuccessDataResult<List<Account>>(this.accountDao.findAll(),"Accounts listed");
    }

    @Override
    public Result createAccount(Account account) {
        this.accountDao.save(account);
        createTeam(account.getId());
        return new SuccessResult("Account added.");
    }

/*
3 goalkeepers
6 defenders
6 midfielders
5 attackers
 */
    public void createTeam(int teamId) {
        List<Player> playerAllList = new ArrayList<>();
        playerAllList.addAll(createRandomTeam.createRandTeamPlayer("Goalkeepers",3,teamId));
        playerAllList.addAll(createRandomTeam.createRandTeamPlayer("Defenders",6,teamId));
        playerAllList.addAll(createRandomTeam.createRandTeamPlayer("Midfielders",6,teamId));
        playerAllList.addAll(createRandomTeam.createRandTeamPlayer("Attackers",5,teamId));

        for (int i =0; i<playerAllList.size(); i++) {
            this.playerDao.save(playerAllList.get(i));
        }
    }
}


