package org.simplilearn.workshop.model;

public class Transaction {
	private int tid;
	private String Faccno;
	private String date;
	private String Taccno;
	private int amount;
	private String acctype;
	private int bal;
	private String transtype;
	public String getTranstype() {
		return transtype;
	}
	public void setTranstype(String transtype) {
		this.transtype = transtype;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getFaccno() {
		return Faccno;
	}
	public void setFaccno(String faccno) {
		this.Faccno = faccno;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTaccno() {
		return Taccno;
	}
	public void setTaccno(String taccno) {
		this.Taccno = taccno;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getAcctype() {
		return acctype;
	}
	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}
	public int getBal() {
		return bal;
	}
	public void setBal(int bal) {
		this.bal = bal;
	}

}
