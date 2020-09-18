package com.gbis.sgcib.kata.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author souli
 *
 */
public class Transaction implements Serializable {
	private static AtomicLong REFERENCE_GENERATOR = new AtomicLong(10000);
	private static final long serialVersionUID = 1L;

	private Long reference;

	private Date dateTime;
	
	private Double amount;
	
	private TransactionType type;
	
	private Account account;
	

	public Transaction(Date dateTime, Double amount, TransactionType type, Account account) {
		super();
		this.reference = REFERENCE_GENERATOR.addAndGet(1);
		this.dateTime = dateTime;
		this.amount = amount;
		this.type = type;
		this.account = account;
	}

	public Long getReference() {
		return reference;
	}

	/**
	 * @return
	 */
	public Date getDateTime() {
		return dateTime;
	}

	/**
	 * @return
	 */
	public Double getAmount() {
		return amount;
	}
	
	
	/**
	 * @return
	 */
	public TransactionType getType() {
		return type;
	}
	
	
	/**
	 * @return the associated operation's account
	 * 
	 */
	public Account getAccount() {
		return account;
	}
	
	/**
	 * @return true if the operation type is credit (withdrawal), false otherwise
	 */
	public boolean isDepositTransaction() {
		return type.equals(TransactionType.DEPOSIT);
	}
	
	/**
	 * @return true if the operation type is debit (withdrawal), false otherwise
	 */
	public boolean isWithdrawalTransaction() {
		return type.equals(TransactionType.WITHDRAWAL);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result + ((reference == null) ? 0 : reference.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Transaction other = (Transaction) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		if (reference == null) {
			if (other.reference != null)
				return false;
		} else if (!reference.equals(other.reference))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
}
