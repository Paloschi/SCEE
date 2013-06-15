package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public abstract class DB {
	
	protected Connection con = null;
	protected Statement stmt = null;
	protected ResultSet rs = null;
    
		public void beginTransaction() throws Exception{
			con.setAutoCommit(false);
    	}
    	
    	public void commit() throws Exception{
			con.commit();
			con.setAutoCommit(true);
    	}
    	
    	public void rollBack() throws Exception{
    		con.rollback();
    		con.setAutoCommit(true);
    	}    	

    	private void clear() throws Exception{
    		if(rs != null){
   				rs.close();
   				rs = null;
   			}
    		if(stmt != null){
   				stmt.close();
   				stmt = null;
   			}    		
    	}
    	
    	public void select(String sql) throws Exception{
    		this.clear();
   			stmt = con.createStatement();		
   			rs = stmt.executeQuery(sql);
    	}

    	public void update(String sql) throws Exception{
    		this.clear();
    		stmt = con.createStatement();	

    		stmt.executeUpdate(sql);
    	}

    	public boolean moveBack() throws Exception{
   			return(rs.previous());
    	}

    	public boolean moveNext() throws Exception{
   			return(rs.next());
    	}
   

    	public String getString(String col) throws Exception{
   			return(rs.getString(col));
    	}

    	public int getInt(String col) throws Exception{
   			return(rs.getInt(col));
    	}

    	public float getFloat(String col) throws Exception{
  			return(rs.getFloat(col));
    	}

    	public long getLong(String col) throws Exception{
  			return(rs.getLong(col));
    	}
    	
    	public boolean getBoolean(String col) throws Exception {
    		try{
    			return rs.getBoolean(col);
    		}
    		catch(Exception e){
    			return false;
    		}
    	}
    	
    	public boolean wasNull() throws Exception {
    		try{
    			return rs.wasNull();
    		}
    		catch(Exception e){
    			return false;
    		}
    	}
    	
    	public Date getDate(String col) throws Exception{
   			return(rs.getDate(col));
    	}
    	
    	public Date getTimestamp(String col) throws Exception{
   			return(rs.getTimestamp(col));
    	}
    	
    	public Date getTime(String col) throws Exception{
   			return(rs.getTime(col));
    	}
    	
    	public boolean colIsSet(String col) {
    		try {
    			rs.findColumn(col);
				return true;
			} catch (SQLException e) {
				return false;
			}
    	}
    	
    	public void close() throws Exception{
    		if(rs != null){
   				rs.close();
   				rs = null;
   			}
    		if(stmt != null){
   				stmt.close();
   				stmt = null;
   			}   		
    		if(con != null){
    			con.close();
    			con=null;
    		}
    	}
}
