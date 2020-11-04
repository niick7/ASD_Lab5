package edu.mum.cs.cs525.labs.command;

public class NoCommand implements Command {
  private TransactionInfo transactionInfo;

  public NoCommand() {};

  @Override
  public void setTransactionInfo(TransactionInfo transactionInfo) {

  }

  @Override
  public void execute() {

  }

  @Override
  public void undo() {

  }
}
