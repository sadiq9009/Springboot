package com.exampleSaad.Saad;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exampleSaad.Saad.Register;
import com.exampleSaad.Saad.Login;


@Component
public class SaadDatabaseconnect {

	
	@Autowired
	DataSource dataSource;
	
	
	// Insert Detail of Employees
	
	 public int insertRegister(Register reg) {
	    	
	    	int result=0;
	try {
		String instemp="insert into AS_TABLE values((select max(regis_id)+1 from AS_TABLE),"
	    		+ "SALARY,NAME,ADDRESS,PHONE,HIRE_DATE,GAMIL,COLLEGE,COURSE)";
	    
		
		if(reg!=null) {
			instemp =instemp.replace("SALARY",Long.toString(reg.getSalary()))
			.replace("NAME", "'"+reg.getName()+"'")
			.replace("ADDRESS", "'"+reg.getAddress()+"'")
			.replace("PHONE", "'"+reg.getPhone()+"'")
			.replace("HIRE_DATE","sysdate")
			.replace("GMAIL", "'"+reg.getGmail()+"'")
			.replace("COLLEGE","'"+reg.getCollege()+"'")
			.replace("COURSE", "'"+reg.getCourse()+"'");
			System.out.println(instemp);
			
				Statement stmt =  dataSource.getConnection().createStatement();
			result =stmt.executeUpdate(instemp);
				
		}
				
	} catch (SQLException e) {
		e.printStackTrace();
	}	
			return result;
	    	
	    }
	 
	 
	 // Multiple Details of Employees
	 
	 
	 public int insertRegisters(List<Register> regs) {
	    	
	    	int result=0;
	try {
		for(Register reg:regs) {
			String instemp="insert into AS_TABLE values((select max(regis_id)+1 from AS_TABLE),"
		    		+ "SALARY,NAME,ADDRESS,PHONE,HIRE_DATE,GAMIL,COLLEGE,COURSE)";
			instemp =instemp.replace("SALARY",Long.toString(reg.getSalary()))
					.replace("NAME", "'"+reg.getName()+"'")
					.replace("ADDRESS", "'"+reg.getAddress()+"'")
					.replace("PHONE", "'"+reg.getPhone()+"'")
					.replace("HIRE_DATE","sysdate")
					.replace("GMAIL", "'"+reg.getGmail()+"'")
					.replace("COLLEGE","'"+reg.getCollege()+"'")
					.replace("COURSE", "'"+reg.getCourse()+"'");
					System.out.println(instemp);
			System.out.println(instemp);
			Statement stmt =  dataSource.getConnection().createStatement();
			result +=  stmt.executeUpdate(instemp);
				
		}
				
	} catch (SQLException e) {
		e.printStackTrace();
	}	
			return result;
	    	
	    }
	 
	 
		// login Username and Password
	 
	 
	 public  Login getUser(String username) {
			
			Login user =new Login();
			
			try {
		        
				Statement stmt = dataSource.getConnection().createStatement();
			ResultSet rs =stmt.executeQuery("select * from login where user_name='"+username+"'");			
				while(rs.next()) {
					user.setUser_name(rs.getString("user_name"));
					user.setPassword(rs.getString("password"));
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return user;
		}

	 
	
}
