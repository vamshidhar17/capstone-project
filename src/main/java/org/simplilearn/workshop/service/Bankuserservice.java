package org.simplilearn.workshop.service;

import java.util.List;


import org.simplilearn.workshop.model.Bankuser;
import org.simplilearn.workshop.model.Transaction;

public interface Bankuserservice {
	
	public  int userregister(Bankuser user);

	public int checklogin(String cid, String pass);
	
	public int deposit(String aid, int y);
	
	public List<Bankuser>  getbal(String aid);
	
	public int inserttrans(Transaction trans);
	
	public int balwithdraw(String aid, String pass, int y);
	
	public List<Transaction> transactionhistory(String cid);
	
	public int reqcheque(String cid);
	
	public List<Bankuser>  getallusers();
	
	public int accountControl(String cid,String trans);
	
	public int depositeControl(String cid,String trans);
	
	public int block(String cid,String trans);

	public List<Bankuser>  getchequerequestusers();
	
	public int chequegrant(String cid);
	
	
}
