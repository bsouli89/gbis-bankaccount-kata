package com.gbis.sgcib.kata.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private Client client;

	private List<Transaction> transactions = new ArrayList<>();


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the account's deposit and withdrawal transactions
	 */
	public List<Transaction> gettransactions() {
		return transactions;
	}
	
	/**
	 * @param transaction
	 * @param account
	 * @return
	 * This method will return the balance of an account at a transaction
	 */
	public Double getBalanceAttransaction(Transaction transaction) {
		return this.gettransactions().stream().filter(op -> {
			return op.getReference() <= transaction.getReference();
		}).mapToDouble(op -> {
			return op.getAmount() * (op.isDepositTransaction() ? 1 : -1);
		}).sum();
	}
	
	/**
	 * @param account
	 * @return balance
	 * This method will return the balance of an account
	 */
	public Double getBalance() {
		Double balance = this.gettransactions().stream().mapToDouble(transaction -> {
			return transaction.getAmount() * (transaction.isDepositTransaction() ? 1 : -1);
		}).sum();
		return balance;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
