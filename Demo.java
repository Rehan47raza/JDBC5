package com;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

public class Demo {


	public static void main(String[] args) {
		DbTransaction db1=null;
		try
		{
		db1 = new DbTransaction("jdbc:oracle:thin:@INGNRGPILPHP01:1521:ORCLILP", "aja185core", "aja185core", "TBL_BOOK_1190848","TBL_AUTHOR_1190848","TBL_BOOK_AUTHOR_1190848");
		//createMethod(db1);
		
		ArrayList<AuthorDetails> ar = TestProcedure.getAuthorDetails(db1);
		
		//System.out.println(ar.size());
		
		for(int i=0;i<ar.size();i++)
		{
			if(ar!=null)
			System.out.println("Author Name:-\t"+ar.get(i).getAuthorName()+"\tTitle:-\t"+ar.get(i).getCity()+"\tPages:-\t"+ar.get(i).getPages());
		}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Occured in main");
		}
		finally
		{
			//cleanup(db1);
		}
	}
	
	
	public static void createMethod(DbTransaction db)
	{
		Connection cn = null;
		Statement st = null;
		
		try
		{
			cn=db.getConnection();
			st=cn.createStatement();
			String sql="CREATE TABLE "+db.getTableName()+ "(book_id number(5) PRIMARY KEY, title varchar(200), price number (7,3), pages number (5))";
			
			st.executeUpdate(sql);
			
			String s1 = "INSERT INTO "+db.getTableName()+ " VALUES(101, 'The Immortals of Meluha', 250.5, 436)";
			String s2 = "INSERT INTO "+db.getTableName()+ " VALUES(102, 'Midnights Children', 324, 647)";
			String s3 = "INSERT INTO "+db.getTableName()+ " VALUES(103, 'The Secret of the Nagas', 250, 398)";
			String s4 = "INSERT INTO "+db.getTableName()+ " VALUES(104, 'Fury', 315, 259)";
			String s5 = "INSERT INTO "+db.getTableName()+ " VALUES(105, 'Harry Potter and the Philosophers Stone', 750, 336)";
			String s6 = "INSERT INTO "+db.getTableName()+ " VALUES(106, 'Harry Potter and the Chamber of Secrets', 650, 300)";
			String s7 = "INSERT INTO "+db.getTableName()+ " VALUES(107, 'Revolution 2020', 345.75, 296)";
			String s8 = "INSERT INTO "+db.getTableName()+ " VALUES(108, 'Five Point Someone', 269, 270)";
			
			st.executeUpdate(s1);

			st.executeUpdate(s2);
			st.executeUpdate(s3);
			st.executeUpdate(s4);
			st.executeUpdate(s5);
			st.executeUpdate(s6);
			st.executeUpdate(s7);
			st.executeUpdate(s8);
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in create method");
			
		}
	}
	
	
	public static void cleanup(DbTransaction db) {
		
		Connection cn = null;
		Statement st = null;
	
		try
		{
			cn=db.getConnection();
			st=cn.createStatement();
			String sql="DROP TABLE "+db.getTableName();
			
			st.executeUpdate(sql);
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in cleanup");
		}	
		
		
	}

}

