package edu.mum.cs.cs525.labs.command;

import edu.mum.cs.cs525.labs.skeleton.Account;

public class TransactionInfo {
  public String fromAccountNumber;
  public String toAccountNumber;
  public double amount;
  public String description;

  public TransactionInfo(String toAccountNumber, double amount) {
    this.toAccountNumber = toAccountNumber;
    this.amount = amount;
  }

  public void setFromAccountNumber(String fromAccountNumber) {
    this.fromAccountNumber = fromAccountNumber;
  }

  public void setToAccountNumber(String toAccountNumber) {
    this.toAccountNumber = toAccountNumber;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getFromAccountNumber() {
    return fromAccountNumber;
  }

  public String getToAccountNumber() {
    return toAccountNumber;
  }

  public double getAmount() {
    return amount;
  }

  public String getDescription() {
    return description;
  }
}
