package com.gbis.sgcib.kata.service;

import com.gbis.sgcib.kata.exception.UnauthorizedTransactionException;
import com.gbis.sgcib.kata.model.Account;
import com.gbis.sgcib.kata.model.Transaction;

/**
 * @author souli
 *
 */
public interface AccountServices {
	public Double getBalance(Account account);
	public Double getBalanceAttransaction(Transaction transaction, Account account);
	public Transaction deposit(Double amount, Account account);
	public Transaction withdrawal(Double amount, Account account) throws UnauthorizedTransactionException;
	public String showAccounttransactionHistory(Account account);
}
