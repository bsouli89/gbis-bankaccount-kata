package com.gbis.sgcib.test.unit;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.gbis.sgcib.kata.service.AccountHistoryMgr;
import com.gbis.sgcib.kata.service.AccountHistoryServices;
import com.gbis.sgcib.kata.service.AccountServices;

@RunWith(MockitoJUnitRunner.class)
public class AccountHistoryShouldTest {
	@Mock
	private com.gbis.sgcib.kata.model.Account account;
	@Mock
	private AccountServices accountMgr;
	private AccountHistoryServices accountHistory;

	@Before
	public void setUp() {
		accountHistory = new AccountHistoryMgr();
		accountMgr.deposit(500d, account);

	}

	@Test
	public void print_account_statement() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);

		String accountStatement = accountHistory.showAccounttransactionHistory(account);

		System.out.flush();
		System.setOut(old);

		Assertions.assertThat(baos.toString()).contains(accountStatement);
	}

}
