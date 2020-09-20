package com.gbis.sgcib.test.unit;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;

import com.gbis.sgcib.kata.exception.UnauthorizedTransactionException;
import com.gbis.sgcib.kata.model.Account;
import com.gbis.sgcib.kata.service.AccountManager;
import com.gbis.sgcib.kata.service.AccountServices;

/**
 * Unit test for account transaction.
 */
/**
 * @author souli
 *
 */
public class AccountTransactionShouldTest {
	private com.gbis.sgcib.kata.model.Account account;
	private AccountServices accountMgr;

	@Before
	public void setUp() {
		account = new Account();
		accountMgr=new AccountManager();
	}

	@Test
	public void execute_a_deposit_transaction() {
		accountMgr.deposit(100d,account);
		Assertions.assertThat(accountMgr.getBalance(account)).isEqualTo(100d);
	}

	@Test
	public void execute_many_deposit_transaction() {
		accountMgr.deposit(100d,account);
		accountMgr.deposit(200d,account);
		accountMgr.deposit(300d,account);
		accountMgr.deposit(10d,account);
		Assertions.assertThat(accountMgr.getBalance(account)).isEqualTo(610d);
	}

	@Test
	public void execute_a_withdrawal_transaction() throws UnauthorizedTransactionException {
		accountMgr.deposit(200d,account);
		accountMgr.withdrawal(50d,account);
		Assertions.assertThat(accountMgr.getBalance(account)).isEqualTo(150d);
	}

	@Test
	public void execute_many_withdrawal_transaction() throws UnauthorizedTransactionException {
		accountMgr.deposit(200d,account);
		accountMgr.withdrawal(50d,account);
		accountMgr.withdrawal(50d,account);
		accountMgr.withdrawal(70d,account);
		Assertions.assertThat(accountMgr.getBalance(account)).isEqualTo(30d);
	}

	@Test(expected = UnauthorizedTransactionException.class)
	public void execute_Unauthorized_withdrawal_transaction() throws UnauthorizedTransactionException {
		accountMgr.deposit(200d,account);
		accountMgr.withdrawal(250d,account);
	}

}
