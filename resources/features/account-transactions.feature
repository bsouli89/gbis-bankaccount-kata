Feature: Account transactions

	Scenario: Deposit  funds
	  Given I deposit 1000 euros
      When I ask the account statement
      Then My account's balance should be 1000 euros
      
      Scenario:Multiple  Deposit S
	  Given I deposit 1000 euros
	  And I deposit 500 euros
      And I deposit 100 euros
      When I ask the account statement
      Then My account's balance should be 1600 euros
    
    
    Scenario: Multiple deposits/withdrawals
      Given I deposit 1000 euros
      And I deposit 500 euros
      And I deposit 200 euros
      And I withdraw 150 euros
      When I ask the account statement
      Then My account's balance should be 1550 euros
      
    Scenario: Illegal debit should fails
      Given I deposit 500 euros
      And I withdraw 600 euros
      When I ask the account statement
      Then My account's balance should be 500 euros