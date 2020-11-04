package edu.mum.cs.cs525.labs.command;

public interface Command {
  public void setTransactionInfo(TransactionInfo transactionInfo);
  public void execute();
  public void undo();
}
