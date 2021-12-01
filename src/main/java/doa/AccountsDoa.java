package doa;

import models.Accounts;
import models.Clients;

import java.util.List;

public interface AccountsDoa {

    void createAccount(Integer clientIdFk);
    List<Accounts> getAllAccounts(Integer clientIdFk);
    List<Accounts>  getAllAccountsGreaterOrLessThanForACustomer(Integer clientIdFk, Integer lowerValue, Integer upperValue);
    List<Accounts> getASpecificAccount(Integer clientIdFk, Integer accountNumber);
    void updateAccount(Integer clientIdFk, Integer accountNumber);
    void deleteAccount(Integer clientIdFk, Integer accountNumber);
    void withdrawOrDeposit(Integer clientIdFk, Integer accountNumber, Accounts account);
    void transfer(Integer clientIdFk, Integer accountNumber1, Integer accountNumber2, Accounts accounts);







}
