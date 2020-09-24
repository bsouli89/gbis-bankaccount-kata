package com.gbis.sgcib.kata.service;

import com.gbis.sgcib.kata.model.Account;
import com.gbis.sgcib.kata.util.BankConstants;

/**
 * class AccountHistoryMgr
 * 
 * @author souli
 *
 */
public class AccountHistoryMgr implements AccountHistoryServices {

	@Override
	public String showAccounttransactionHistory(Account account) {
		StringBuilder statementSB = new StringBuilder();
		statementSB.append(BankConstants.TRANSACTION_STATEMENT_HEADER).append(System.lineSeparator());

		account.gettransactions().forEach(transaction -> {
			statementSB.append(transaction.getReference()).append(BankConstants.TRANSACTION_STATEMENT_SEPARATOR)
					.append(transaction.getDateTime()).append(BankConstants.TRANSACTION_STATEMENT_SEPARATOR)
					.append((transaction.isDepositTransaction() ? "" : "-") + transaction.getAmount())
					.append(BankConstants.TRANSACTION_STATEMENT_SEPARATOR)
					.append(account.getBalanceAttransaction(transaction)).append(System.lineSeparator());
		});

		System.out.print(statementSB);

		return statementSB.toString();
	}

}
