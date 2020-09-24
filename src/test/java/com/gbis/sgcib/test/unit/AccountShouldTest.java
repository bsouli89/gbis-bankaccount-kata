package com.gbis.sgcib.test.unit;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.gbis.sgcib.kata.exception.UnauthorizedTransactionException;
import com.gbis.sgcib.kata.model.Account;
import com.gbis.sgcib.kata.service.AccountManager;
import com.gbis.sgcib.kata.service.AccountServices;

@RunWith(MockitoJUnitRunner.class)
public class AccountShouldTest {

	private com.gbis.sgcib.kata.model.Account account;

	private AccountServices accountMgr;

	@Before
	public void setUp() {
		account = new Account();
		accountMgr = new AccountManager();
		accountMgr.deposit(150d, account);

	}

	@Test
	public void execute_a_balance_request() throws UnauthorizedTransactionException {
		Assertions.assertThat(account.getBalance()).isEqualTo(150d);
	}

	@Test
	public void execute_a_balanceAttransaction_request() throws UnauthorizedTransactionException {
		Assertions.assertThat(account.getBalanceAttransaction(account.gettransactions().get(0)))
				.isEqualTo(150d);
	}
}
