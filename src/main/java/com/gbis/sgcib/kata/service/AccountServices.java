package com.gbis.sgcib.kata.service;

import com.gbis.sgcib.kata.exception.UnauthorizedTransactionException;
import com.gbis.sgcib.kata.model.Account;
import com.gbis.sgcib.kata.model.Transaction;

/**
 * @author souli
 *
 */
public interface AccountServices {
	public Transaction deposit(Double amount, Account account);
	public Transaction withdrawal(Double amount, Account account) throws UnauthorizedTransactionException;
}
