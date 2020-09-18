package com.gbis.sgcib.test.acceptance;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
/**
 * @author souli
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "resources", plugin = {
		"pretty", "html:target/cucumber-reports" }, monochrome = true, snippets = SnippetType.CAMELCASE)
public class AccountTransactionsTest {
 }
