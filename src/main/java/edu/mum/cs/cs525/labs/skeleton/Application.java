package edu.mum.cs.cs525.labs.skeleton;

import edu.mum.cs.cs525.labs.command.CommandManagement;
import edu.mum.cs.cs525.labs.command.DepositCommand;
import edu.mum.cs.cs525.labs.command.TransferFundsCommand;
import edu.mum.cs.cs525.labs.command.WithdrawCommand;

public class Application {
	public static void main(String[] args) {
		AccountService accountService = new AccountServiceImpl();

		DepositCommand depositCommand = new DepositCommand(accountService);
		WithdrawCommand withdrawCommand = new WithdrawCommand(accountService);
		TransferFundsCommand transferFundsCommand = new TransferFundsCommand(accountService);

		CommandManagement management = new CommandManagement();
		management.setDepositCommand(depositCommand);
		management.setWithdrawCommand(withdrawCommand);
		management.setTransferFundsCommand(transferFundsCommand);

		// create 2 accounts;
		Account acc1 = accountService.createAccount("1263862", "Frank Brown");
		Account acc2 = accountService.createAccount("4253892", "John Doe");
		// use account 1;
		management.deposit(acc1.getAccountNumber(), 240);
		management.deposit(acc1.getAccountNumber(), 529);
		management.withdraw(acc1.getAccountNumber(), 230);
		// use account 2;
		management.deposit(acc2.getAccountNumber(), 12450);
		management.transferFunds(acc2.getAccountNumber(), acc1.getAccountNumber(), 100, "payment of invoice 10232");
		// show balances

		management.deposit(acc2.getAccountNumber(), 1000);
		management.undo();
		management.redo();
		management.redo();

		for (Account account : accountService.getAllAccounts()) {
			Customer customer = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountNumber());
			System.out.println("Account Holder: " + customer.getName());
			
			System.out.println("-Date-------------------------" 
					+ "-Description------------------" 
					+ "-Amount-------------");
			
			for (AccountEntry entry : account.getEntryList()) {
				System.out.printf("%30s%30s%20.2f\n", 
						entry.getDate().toString(), 
						entry.getDescription(),
						entry.getAmount());
			}
			
			System.out.println("----------------------------------------" + "----------------------------------------");
			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:", account.getBalance());
		}
	}

}
