package doa;

import models.Accounts;
import models.Clients;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.H2Util;
import util.H2UtilAccounts;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountsDoaImlementationTest {
    AccountsDoa accountsDoa;

    public AccountsDoaImlementationTest(){
        this.accountsDoa = new AccountsDoaImlementation(H2UtilAccounts.url, H2UtilAccounts.username,H2UtilAccounts.password);
    }

    @BeforeEach
    void setUp() {
        //H2Util.createTable();
        H2UtilAccounts.createTable();
    }

    @AfterEach
    void tearDown() {
        //H2Util.dropTable();
        H2UtilAccounts.dropTable();
    }

    @Test
    void createAccount() {
        List<Accounts> expectedResult = new ArrayList();
        expectedResult.add(new Accounts(1, 1, 1000, 0, 0, 0));
        expectedResult.add(new Accounts(1, 2, 1000, 0, 0, 0));
        expectedResult.add(new Accounts(1, 3, 1000, 0, 0, 0));
        accountsDoa.createAccount(1);
        accountsDoa.createAccount(1);
        accountsDoa.createAccount(1);



        Integer actualResult = accountsDoa.getAllAccounts(1).size();


        assertEquals(expectedResult.size(),actualResult);
    }

    @Test
    void getAllAccounts() {

        List<Accounts> expectedResult = new ArrayList();
        expectedResult.add(new Accounts(1, 1, 1000, 0, 0, 0));
        expectedResult.add(new Accounts(1, 2, 1000, 0, 0, 0));
        expectedResult.add(new Accounts(1, 3, 1000, 0, 0, 0));
        accountsDoa.createAccount(1);
        accountsDoa.createAccount(1);
        accountsDoa.createAccount(1);



        Integer actualResult = accountsDoa.getAllAccounts(1).size();


        assertEquals(expectedResult.size(),actualResult);
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