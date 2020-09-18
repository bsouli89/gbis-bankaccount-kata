package com.gbis.sgcib.test.acceptance;

import org.assertj.core.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gbis.sgcib.kata.service.AccountManager;
import com.gbis.sgcib.kata.service.AccountServices;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author souli
 *
 */
public class AccountTransactionsStepDefinitions {
	
	private com.gbis.sgcib.kata.model.Account account;
	private AccountServices accountMgr;
	private String accountStatement;
	
	
	private final Logger LOG = LoggerFactory.getLogger(AccountTransactionsStepDefinitions.class);


	@Before
	public void setUp() {
		account = new com.gbis.sgcib.kata.model.Account();
		accountMgr=new AccountManager();
		
	}
	

	@Given("I deposit {int} euros")
	public void iDeposit(Integer amount) {
		accountMgr.deposit(amount.doubleValue(),account); 
	}

	@Given("I withdraw {int} euros")
	public void iWithdraw(Integer amount) {
		try {
			accountMgr.withdrawal(amount.doubleValue(),account); 
		}
		catch(Exception e) {
			LOG.info("Withdrawal transaction not authorized");
		}
	}

	@When("I ask the account statement")
	public void iAskTheAccountStatement() {
		accountStatement = accountMgr.showAccounttransactionHistory(account);
	}

	@Then("My account's balance should be {int} euros")
	public void myAccountBalanceShouldBe(Integer balance) {
		String[] statementLines = accountStatement.split(System.lineSeparator());
		String[] lastTransactionParts = statementLines[statementLines.length-1].split("\\|");
		Integer statementBalance = (int) Double.parseDouble(lastTransactionParts[lastTransactionParts.length-1]);
		Assertions.assertThat(statementBalance).isEqualTo(balance);
	}

}
