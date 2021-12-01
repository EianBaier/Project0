package services;

import doa.AccountsDoa;
import models.Accounts;
import models.Clients;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountsServiceTest {

    AccountsDoa accountsDoa = Mockito.mock((AccountsDoa.class));

    AccountsService accountsService;

    public AccountsServiceTest(){


        this.accountsService = new AccountsService(accountsDoa);
    }

    @Test
    void createAccount() {

        Accounts expectedResult = (new Accounts(1, 1, 1000, 0, 0, 0));

        accountsService.createAccount(1);

    }

    @Test
    void getAllAccounts() {
        List<Accounts> Accounts = new ArrayList();
        Accounts.add(new Accounts(1, 1, 1000, 0, 0, 0));
        Accounts.add(new Accounts(1, 1, 1000, 0, 0, 0));
        Accounts.add(new Accounts(1, 1, 1000, 0, 0, 0));
        List<Accounts> expectedValue = Accounts;

        List<Accounts> actualResult = accountsDoa.getAllAccounts(1);

        assertEquals(expectedValue, actualResult);


    }

    @Test
    void getAllAccountsGreaterOrLessThanForACustomer() {
    }

    @Test
    void getASpecificAccount() {
    }

    @Test
    void updateAccount() {
    }

    @Test
    void deleteAccount() {
    }

    @Test
    void withdrawOrDeposit() {
    }

    @Test
    void transfer() {
    }
}