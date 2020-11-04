package edu.mum.cs.cs525.labs.command;

import edu.mum.cs.cs525.labs.skeleton.AccountService;

public class DepositCommand implements Command {
  private AccountService accountService;
  private TransactionInfo transactionInfo;

  public DepositCommand(AccountService accountService) {
    this.accountService = accountService;
  }

  public void setTransactionInfo(TransactionInfo transactionInfo) {
    this.transactionInfo = transactionInfo;
  }

  @Override
  public void execute() {
    accountService.deposit(transactionInfo.getToAccountNumber(), transactionInfo.getAmount());
  }

  @Override
  public void undo() {
    accountService.withdraw(transactionInfo.getToAccountNumber(), transactionInfo.getAmount());
  }
}
