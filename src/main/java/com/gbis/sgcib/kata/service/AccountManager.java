package com.gbis.sgcib.kata.service;

import java.io.Serializable;
import java.util.Date;

import com.gbis.sgcib.kata.exception.UnauthorizedTransactionException;
import com.gbis.sgcib.kata.model.Account;
import com.gbis.sgcib.kata.model.Transaction;
import com.gbis.sgcib.kata.model.TransactionType;
import com.gbis.sgcib.kata.util.BankConstants;


/**
 * @author souli
 *
 */
public class AccountManager implements Serializable, AccountServices {


	private static final long serialVersionUID = 1L;

	/**
	 * @param account
	 * @return
	 */
	public Double getBalance(Account account) {
		Double balance = account.gettransactions().stream().mapToDouble(transaction -> {
			return transaction.getAmount() * (transaction.isDepositTransaction() ? 1 : -1);
		}).sum();

		return balance;
	}
	/**
	 * @param transaction
	 * @param account
	 * @return
	 */
	public Double getBalanceAttransaction(Transaction transaction, Account account) {
		return account.gettransactions().stream().filter(op -> {
			return op.getReference() <= transaction.getReference();
		}).mapToDouble(op -> {
			return op.getAmount() * (op.isDepositTransaction() ? 1 : -1);
		}).sum();
	}
	/**
	 * @param amount
	 * @param account
	 * @return the  deposit transaction object
	 */
	public Transaction deposit(Double amount, Account account) {
		Transaction transaction = new Transaction(new Date(System.currentTimeMillis()), amount, TransactionType.DEPOSIT,
				account);
		account.gettransactions().add(transaction);

		return transaction;
	}
	/**
	 * @param amount
	 * @return the  withdrawal transaction object       
	 * @throws UnauthorizedTransactionException 
	 */
	public Transaction withdrawal(Double amount, Account account) throws UnauthorizedTransactionException {
		if (getBalance(account) < amount) {
			throw new UnauthorizedTransactionException(account, TransactionType.WITHDRAWAL);
		}
		Transaction transaction = new Transaction(new Date(System.currentTimeMillis()), amount,
				TransactionType.WITHDRAWAL, account);
		account.gettransactions().add(transaction);

		return transaction;
	}
	/**
	 * @param account
	 * @return statement history transaction
	 */
	public String showAccounttransactionHistory(Account account) {
		StringBuilder statementSB = new StringBuilder();
		statementSB.append(BankConstants.TRANSACTION_STATEMENT_HEADER).append(System.lineSeparator());

		account.gettransactions().forEach(transaction -> {
			statementSB.append(transaction.getReference()).append(BankConstants.TRANSACTION_STATEMENT_SEPARATOR)
					.append(transaction.getDateTime()).append(BankConstants.TRANSACTION_STATEMENT_SEPARATOR)
					.append((transaction.isDepositTransaction() ? "" : "-") + transaction.getAmount())
					.append(BankConstants.TRANSACTION_STATEMENT_SEPARATOR)
					.append(getBalanceAttransaction(transaction,account))
					.append(System.lineSeparator());
		});

		System.out.print(statementSB);

		return statementSB.toString();
	}
}
