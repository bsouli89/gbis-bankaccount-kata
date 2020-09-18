$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("resources/features/account-transactions.feature");
formatter.feature({
  "name": "Account transactions",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Deposit  funds",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I deposit 1000 euros",
  "keyword": "Given "
});
formatter.match({
  "location": "AccountTransactionsStepDefinitions.iDeposit(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I ask the account statement",
  "keyword": "When "
});
formatter.match({
  "location": "AccountTransactionsStepDefinitions.iAskTheAccountStatement()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "My account\u0027s balance should be 1000 euros",
  "keyword": "Then "
});
formatter.match({
  "location": "AccountTransactionsStepDefinitions.myAccountBalanceShouldBe(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Multiple  Deposit S",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I deposit 1000 euros",
  "keyword": "Given "
});
formatter.match({
  "location": "AccountTransactionsStepDefinitions.iDeposit(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I deposit 500 euros",
  "keyword": "And "
});
formatter.match({
  "location": "AccountTransactionsStepDefinitions.iDeposit(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I deposit 100 euros",
  "keyword": "And "
});
formatter.match({
  "location": "AccountTransactionsStepDefinitions.iDeposit(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I ask the account statement",
  "keyword": "When "
});
formatter.match({
  "location": "AccountTransactionsStepDefinitions.iAskTheAccountStatement()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "My account\u0027s balance should be 1600 euros",
  "keyword": "Then "
});
formatter.match({
  "location": "AccountTransactionsStepDefinitions.myAccountBalanceShouldBe(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Multiple deposits/withdrawals",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I deposit 1000 euros",
  "keyword": "Given "
});
formatter.match({
  "location": "AccountTransactionsStepDefinitions.iDeposit(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I deposit 500 euros",
  "keyword": "And "
});
formatter.match({
  "location": "AccountTransactionsStepDefinitions.iDeposit(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I deposit 200 euros",
  "keyword": "And "
});
formatter.match({
  "location": "AccountTransactionsStepDefinitions.iDeposit(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I withdraw 150 euros",
  "keyword": "And "
});
formatter.match({
  "location": "AccountTransactionsStepDefinitions.iWithdraw(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I ask the account statement",
  "keyword": "When "
});
formatter.match({
  "location": "AccountTransactionsStepDefinitions.iAskTheAccountStatement()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "My account\u0027s balance should be 1550 euros",
  "keyword": "Then "
});
formatter.match({
  "location": "AccountTransactionsStepDefinitions.myAccountBalanceShouldBe(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Illegal debit should fails",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I deposit 500 euros",
  "keyword": "Given "
});
formatter.match({
  "location": "AccountTransactionsStepDefinitions.iDeposit(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I withdraw 600 euros",
  "keyword": "And "
});
formatter.match({
  "location": "AccountTransactionsStepDefinitions.iWithdraw(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I ask the account statement",
  "keyword": "When "
});
formatter.match({
  "location": "AccountTransactionsStepDefinitions.iAskTheAccountStatement()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "My account\u0027s balance should be 500 euros",
  "keyword": "Then "
});
formatter.match({
  "location": "AccountTransactionsStepDefinitions.myAccountBalanceShouldBe(Integer)"
});
formatter.result({
  "status": "passed"
});
});