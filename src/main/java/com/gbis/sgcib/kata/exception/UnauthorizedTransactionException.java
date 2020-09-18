package com.gbis.sgcib.kata.exception;

import com.gbis.sgcib.kata.model.Account;
import com.gbis.sgcib.kata.model.Transaction;
import com.gbis.sgcib.kata.model.TransactionType;
import com.gbis.sgcib.kata.model.Transaction;

/**
 * @author souli
 *
 */
public class UnauthorizedTransactionException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "Unauthorized transaction %s on account %s";

	public UnauthorizedTransactionException(Account account, TransactionType transactionType) {
		super(String.format(MESSAGE, transactionType, account.getId()));
	}
}
