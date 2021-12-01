package models;

public class Accounts {

    private Integer clientIdFk;
    private Integer accountNumber;
    private Integer amountInAccount;

    public Integer getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(Integer withdraw) {
        this.withdraw = withdraw;
    }

    public Integer getDeposit() {
        return deposit;
    }

    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    private Integer withdraw;
    private Integer deposit;
    private Integer amount;

    public Integer getClientIdFk() {
        return clientIdFk;
    }

    public void setClientIdFk(Integer clientIdFk) {
        this.clientIdFk = clientIdFk;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Integer getAmountInAccount() {
        return amountInAccount;
    }

    public void setAmountInAccount(Integer amountInAccount) {
        this.amountInAccount = amountInAccount;
    }


    public Accounts(){

    }

    public Accounts(Integer clientIdFk, Integer accountNumber, Integer amountInAccount, Integer withdraw, Integer deposit, Integer amount){
        this.clientIdFk = clientIdFk;
        this.accountNumber = accountNumber;
        this.amountInAccount = amountInAccount;
        this.withdraw = withdraw;
        this.deposit = deposit;
        this.amount = amount;
    }

}
