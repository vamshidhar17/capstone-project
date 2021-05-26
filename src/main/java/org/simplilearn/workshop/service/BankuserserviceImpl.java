package org.simplilearn.workshop.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;


import org.simplilearn.workshop.model.Bankuser;
import org.simplilearn.workshop.model.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class BankuserserviceImpl implements Bankuserservice {
	
	private JdbcTemplate jdbcTemplate;

	public BankuserserviceImpl(DataSource dataSoruce) {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}


	@Override
	public int userregister(Bankuser user) {
		try {
			String sql = "INSERT INTO list_of_customer_details(account_number,user_name,full_name,password,gender,phone,email,address,aadhar_number,country,date_of_birth,type) values(?,?,?,?,?,?,?,?,?,?,?,?)";
			jdbcTemplate.update(sql,
					new Object[] {user.getAcc_num(),user.getUsername(),user.getFullname(),user.getPassword(),user.getGender(),user.getPhone(),user.getEmail(),user.getAddress(),user.getAadhar(),user.getCountry(),user.getDob(),user.getType()});
			return 1;
		}catch (Exception e1) {
				e1.printStackTrace();
				return 0;
			}		
		
	}
	
	@Override
	public int checklogin(String cid, String pass) {
		
		String sql="select * from list_of_customer_details where account_number='"+cid+"' and password='"+pass+"'";
				//System.out.println(pass);
				UserMapper a = new UserMapper();
				
				List<Bankuser> s=jdbcTemplate.query(sql, a);
				//System.out.println(s.get(0).getBlocked());
				if(s.get(0).getBlocked().equals("ublock")) {
					return 2;
				}
				 return s.size() >0 ?1 :0;
			}
			class UserMapper implements RowMapper<Bankuser>
			{
				public Bankuser mapRow(ResultSet rs, int rowNum) throws SQLException {
									Bankuser a = new Bankuser();
									//System.out.println(rs.getString("user_name"));
									a.setUsername(rs.getString("user_name"));
									a.setBlocked(rs.getString("blocked_status"));
									a.setDeposit_status(rs.getString("deposit_status"));
									a.setTrans_status(rs.getString("trans_status"));
									return a;
								}
			}
			@Override
			public int deposit(String aid, int y) {
				if(y==-1) {
				String sql="select * from list_of_customer_details where account_number='"+aid+"'";
				System.out.println(aid);
				UserMapper a = new UserMapper();
				
				List<Bankuser> s=jdbcTemplate.query(sql, a);
				System.out.println(s.get(0).getBlocked());
				System.out.println(s.get(0).getDeposit_status());
				System.out.println(s.size());
				if(s.get(0).getDeposit_status().equals("allow")) {
					return 2;
				}
				return 0;
				}
				String sql1 = "UPDATE list_of_customer_details SET balance=balance+? where account_number=?";
				try {
					int counter = jdbcTemplate.update(sql1,
							new Object[] { y,aid});
					return counter;
				} catch (Exception e) {
					e.printStackTrace();
					return 0;
				}
			}


			@Override
			public List<Bankuser> getbal(String aid) {
				List<Bankuser> ll = jdbcTemplate.query("SELECT * FROM list_of_customer_details where account_number='"+aid+"'", new RowMapper<Bankuser>() {

					@Override
					public Bankuser mapRow(ResultSet rs, int rowNum) throws SQLException {
						Bankuser b = new Bankuser();
						b.setAadhar(rs.getString("aadhar_number"));
						b.setAddress(rs.getString("address"));
						b.setBalance(rs.getInt("balance"));
						b.setCountry(rs.getString("country"));
						b.setDob(rs.getString("date_of_birth"));
						b.setEmail(rs.getString("email"));
						b.setFullname(rs.getString("full_name"));
						b.setGender(rs.getString("gender"));
						b.setPhone(rs.getString("phone"));
						b.setUsername(rs.getString("user_name"));
						b.setAcc_num(rs.getString("account_number"));
						b.setType(rs.getString("type"));
						b.setTrans_status(rs.getString("trans_status"));
						b.setCheque(rs.getBoolean("cheque_book"));
						return b;
					}

				});
				return ll;
			}


			@Override
			public int inserttrans(Transaction trans) {
				String sql = "INSERT INTO transaction(trans_id,from_acc_no,date_trans,to_acc,amount,to_acc_type,balance,transtype) values(?,?,?,?,?,?,?,?)";
				try {

					int counter = jdbcTemplate.update(sql,
							new Object[] {trans.getTid(),trans.getFaccno(),trans.getDate(),trans.getTaccno(),trans.getAmount(),trans.getAcctype(),trans.getBal(),trans.getTranstype()});

					return counter;

				} catch (Exception e) {
					e.printStackTrace();
					return 0;
				}
			}


			@Override
			public int balwithdraw(String aid, String pass, int y) {
				String sql = "UPDATE list_of_customer_details SET balance=? where account_number=? and password=?";
				try {
					int counter = jdbcTemplate.update(sql,
							new Object[] { y,aid,pass});
					return counter;
				} catch (Exception e) {
					e.printStackTrace();
					return 0;
				}
			}


			@Override
			public List<Transaction> transactionhistory(String cid) {
				List<Transaction> ll = jdbcTemplate.query("select * from transaction where from_acc_no='"+cid+"' or to_acc='"+cid+"'", new RowMapper<Transaction>() {

					@Override
					public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
						Transaction tr = new Transaction();
						tr.setAcctype(rs.getString("to_acc_type"));
						tr.setAmount(rs.getInt("amount"));
						tr.setBal(rs.getInt("balance"));
						tr.setDate(rs.getString("date_trans"));
						tr.setFaccno(rs.getString("from_acc_no"));
						tr.setTaccno(rs.getString("to_acc"));
						tr.setTid(rs.getInt("trans_id"));

						
						return tr;
					}

				});

				return ll;
			}


			@Override
			public int reqcheque(String cid) {
				String sql1="select * from list_of_customer_details where account_number='"+cid+"'";
				//System.out.println(pass);
				UserMapper a = new UserMapper();
				
				List<Bankuser> s=jdbcTemplate.query(sql1, a);
				System.out.println(s.get(0).isCheque());
				if(s.get(0).isCheque()) {
					return 2;
				}else {
				
				String sql = "UPDATE list_of_customer_details SET cheque_book=? where account_number=?";
				try {
					int counter = jdbcTemplate.update(sql,
							new Object[] {true,cid});
					return 1;
				} catch (Exception e) {
					e.printStackTrace();
					return 0;
				}
				}
			}


			@Override
			public List<Bankuser> getallusers() {
				List<Bankuser> ll = jdbcTemplate.query("SELECT * FROM list_of_customer_details", new RowMapper<Bankuser>() {

					@Override
					public Bankuser mapRow(ResultSet rs, int rowNum) throws SQLException {
						Bankuser b = new Bankuser();
						b.setAadhar(rs.getString("aadhar_number"));
						b.setAddress(rs.getString("address"));
						b.setBalance(rs.getInt("balance"));
						b.setCountry(rs.getString("country"));
						b.setDob(rs.getString("date_of_birth"));
						b.setEmail(rs.getString("email"));
						b.setFullname(rs.getString("full_name"));
						b.setGender(rs.getString("gender"));
						b.setPhone(rs.getString("phone"));
						b.setUsername(rs.getString("user_name"));
						b.setAcc_num(rs.getString("account_number"));
						b.setType(rs.getString("type"));
						b.setBlocked(rs.getString("blocked_status"));
						b.setDeposit_status(rs.getString("deposit_status"));
						b.setTrans_status(rs.getString("trans_status"));
						//System.out.println((rs.getBoolean("cheque_book")));
						b.setCheque(rs.getBoolean("cheque_book"));
						return b;
					}

				});
				return ll;
			}


			@Override
			public int accountControl(String cid, String trans) {
				String sql = "UPDATE list_of_customer_details SET trans_status=? where account_number=?";
				try {
					System.out.println(1111);
					int counter = jdbcTemplate.update(sql,
							new Object[] {trans,cid});
					return 1;
				} catch (Exception e) {
					e.printStackTrace();
					return 0;
				}
			}


			@Override
			public int depositeControl(String cid, String trans) {
				String sql = "UPDATE list_of_customer_details SET deposit_status=? where account_number=?";
				try {
					System.out.println(1111);
					int counter = jdbcTemplate.update(sql,
							new Object[] {trans,cid});
					return 1;
				} catch (Exception e) {
					e.printStackTrace();
					return 0;
				}
			}


			@Override
			public int block(String cid, String trans) {
				String sql = "UPDATE list_of_customer_details SET blocked_status=? where account_number=?";
				try {
					//System.out.println(1111);
					int counter = jdbcTemplate.update(sql,
							new Object[] {trans,cid});
					return 1;
				} catch (Exception e) {
					e.printStackTrace();
					return 0;
				}
			}


			@Override
			public List<Bankuser> getchequerequestusers() {
				List<Bankuser> ll = jdbcTemplate.query("SELECT * FROM list_of_customer_details where cheque_book=true", new RowMapper<Bankuser>() {

					@Override
					public Bankuser mapRow(ResultSet rs, int rowNum) throws SQLException {
						Bankuser b = new Bankuser();
						b.setAadhar(rs.getString("aadhar_number"));
						b.setAddress(rs.getString("address"));
						b.setBalance(rs.getInt("balance"));
						b.setCountry(rs.getString("country"));
						b.setDob(rs.getString("date_of_birth"));
						b.setEmail(rs.getString("email"));
						b.setFullname(rs.getString("full_name"));
						b.setGender(rs.getString("gender"));
						b.setPhone(rs.getString("phone"));
						b.setUsername(rs.getString("user_name"));
						b.setAcc_num(rs.getString("account_number"));
						b.setType(rs.getString("type"));
						b.setBlocked(rs.getString("blocked_status"));
						b.setDeposit_status(rs.getString("deposit_status"));
						b.setTrans_status(rs.getString("trans_status"));
						//System.out.println((rs.getBoolean("cheque_book")));
						b.setCheque(rs.getBoolean("cheque_book"));
						return b;
					}

				});
				return ll;
			}


			@Override
			public int chequegrant(String cid) {
				String sql = "UPDATE list_of_customer_details SET cheque_book=? where account_number=?";
				try {
					//System.out.println(1111);
					int counter = jdbcTemplate.update(sql,
							new Object[] {false,cid});
					return 1;
				} catch (Exception e) {
					e.printStackTrace();
					return 0;
				}
			}




			
			
			
			
}
