package jp.ac.hal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemoDAO {
	private Connection getConnection()
			throws ClassNotFoundException, SQLException{
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(
					"jdbc:mysql://localhost/jv23?characterEncodintg=utf8", "root", "");
	}
	
	public ArrayList<Memo> select(){
		ArrayList<Memo> list = new ArrayList<Memo>();
		
		try(
				Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement("select * from kadai03");
				){
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Memo m = new Memo();
				m.setId(rs.getInt("id"));
				m.setTitle(rs.getString("title"));
				m.setCategory(rs.getString("category"));
				m.setMemo(rs.getString("memo"));
				m.setPosttime(rs.getDate("posttime"));
				
				list.add(m);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e1){
			e1.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<Memo> select(String title){
		ArrayList<Memo> list = new ArrayList<Memo>();
		try(
				Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement("select * from kadai03 where title like ? ");
				){
			ps.setString(1, "%" + title + "%");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Memo m = new Memo();
				m.setId(rs.getInt("id"));
				m.setTitle(rs.getString("title"));
				m.setCategory(rs.getString("category"));
				m.setMemo(rs.getString("memo"));
				m.setPosttime(rs.getDate("posttime"));
				
				list.add(m);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e1){
			e1.printStackTrace();
		}
		return list;
	}
	
	public int add(String title, String category, String memo){
		int count = 0; //更新件数
		
		try(
				Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement("insert into kadai03(title, category, memo) values(?, ?, ?)");
				){
			ps.setString(1, title);
			ps.setString(2, category);
			ps.setString(3, memo);
			
			count = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		return count;
	}
	
	public int update(int id, String title, String category, String memo) {
		int count = 0; // 更新件数
		
		try(
				Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement("update kadai03 set title = ?, category = ?, memo = ? where id = ?");
				){
			ps.setString(1, title);
			ps.setString(2,  category);
			ps.setString(3, memo);
			ps.setInt(4, id);
			
			count = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		return count;
	}
	
	public int delete(int id) {
		int count = 0; // 更新件数
		
		try(
				Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement("delete from kadai03 where id = ?");
				){
			ps.setInt(1, id);
			
			count = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		return count;
	}
}
