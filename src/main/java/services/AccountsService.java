package services;

import doa.AccountsDoa;
import doa.AccountsDoaImlementation;
import models.Accounts;
import models.Clients;

import java.util.List;

public class AccountsService {

    AccountsDoa accountsDoa;

    public AccountsService(AccountsDoa accountsDoa){

        this.accountsDoa = accountsDoa;

    }

    public AccountsService(){

        this.accountsDoa = new AccountsDoaImlementation();

    }

    public void createAccount(Integer ClientIdFk){

        accountsDoa.createAccount(ClientIdFk);
    }

    public List<Accounts> getAllAccounts(Integer ClientIdFk) {

        return accountsDoa.getAllAccounts(ClientIdFk);
        // return null;

    }

    public List<Accounts> getAllAccountsGreaterOrLessThanForACustomer(Integer clientIdFk, Integer lowerValue, Integer upperValue) {

        return accountsDoa.getAllAccountsGreaterOrLessThanForACustomer(clientIdFk, lowerValue, upperValue);
        // return null;

    }

    public List<Accounts> getASpecificAccount(Integer clientIdFk, Integer accountNumber){

        return accountsDoa.getASpecificAccount(clientIdFk,accountNumber);
    }

    public void updateAccount(Integer clientIdFk, Integer accountNumber){
        accountsDoa.updateAccount(clientIdFk, accountNumber);
    }

    public void deleteAccount(Integer clientIdFk, Integer accountNumber){
        accountsDoa.deleteAccount(clientIdFk, accountNumber);
    }

    public void withdrawOrDeposit(Integer clientIdFk, Integer accountNumber, Accounts account){
        accountsDoa.withdrawOrDeposit(clientIdFk, accountNumber, account);
    }

    public void transfer(Integer clientIdFk, Integer accountNumber1, Integer accountNumber2, Accounts accounts){
        accountsDoa.transfer(clientIdFk, accountNumber1, accountNumber2, accounts);
    }
}
