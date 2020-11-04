package edu.mum.cs.cs525.labs.command;

import java.util.Stack;

public class CommandManagement {
  private Command depositCommand;
  private Command withdrawCommand;
  private Command transferFundsCommand;
  private Stack<Command> previousCommands;
  private Stack<Command> nextCommands;

  public CommandManagement() {
    this.depositCommand = new NoCommand();
    this.withdrawCommand = new NoCommand();
    this.transferFundsCommand = new NoCommand();
    this.previousCommands = new Stack<>();
    this.nextCommands = new Stack<>();
  }

  public void setDepositCommand(Command depositCommand) {
    this.depositCommand = depositCommand;
  }

  public void setWithdrawCommand(Command withdrawCommand) {
    this.withdrawCommand = withdrawCommand;
  }

  public void setTransferFundsCommand(Command transferFundsCommand) {
    this.transferFundsCommand = transferFundsCommand;
  }

  public void deposit(String accountNumber, double amount) {
    TransactionInfo info = new TransactionInfo(accountNumber, amount);
    depositCommand.setTransactionInfo(info);
    executeCommand(depositCommand);
  }

  public void withdraw(String accountNumber, double amount) {
    TransactionInfo info = new TransactionInfo(accountNumber, amount);
    withdrawCommand.setTransactionInfo(info);
    executeCommand(withdrawCommand);
  }

  public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
    TransactionInfo info = new TransactionInfo(toAccountNumber, amount);
    info.setFromAccountNumber(fromAccountNumber);
    info.setDescription(description);
    transferFundsCommand.setTransactionInfo(info);
    executeCommand(transferFundsCommand);
  }

  public void executeCommand(Command command) {
    command.execute();
    previousCommands.push(command);
    nextCommands.push(command);
  }

  public void undo(){
    if (previousCommands.empty()) {
      return;
    }
    Command command = previousCommands.pop();
    command.undo();
    nextCommands.push(command);
  }

  public void redo(){
    if (nextCommands.empty()) {
      return;
    }
    Command command = nextCommands.pop();
    command.execute();
    previousCommands.push(command);
  }
}
