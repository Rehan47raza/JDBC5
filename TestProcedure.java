
package com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TestProcedure {
	
	
	public static ArrayList<AuthorDetails> getAuthorDetails(DbTransaction db) 
	{
		ArrayList<AuthorDetails> ar = new ArrayList<AuthorDetails>();
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		try
		{
			cn=db.getConnection();
			st=cn.createStatement();
			String sql="SELECT AUTHOR_NAME,TITLE,PAGES FROM TBL_AUTHOR_1190848,TBL_BOOK_1190848,TBL_BOOK_AUTHOR_1190848 WHERE TBL_BOOK_AUTHOR_1190848.AUTHOR_ID=TBL_AUTHOR_1190848.AUTHOR_ID AND TBL_BOOK_1190848.BOOK_ID= TBL_BOOk_AUTHOR_1190848.BOOK_ID";
			rs = st.executeQuery(sql);
			//System.out.println(rs.getFetchSize());
			while(rs.next())
			{
				AuthorDetails a = new AuthorDetails();
				a.setAuthorName(rs.getString(1));
				a.setCity(rs.getString(2));
				a.setPages(rs.getInt(3));
				
				
				ar.add(a);
				
			}
			
			
		}catch (Exception e) {
			return null;
		}
		
		return ar;
	}
	

}
