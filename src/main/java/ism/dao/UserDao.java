package ism.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ism.bean.UserBean;
import ism.util.PgAdmin4ConnectionForTodo;

public class UserDao {

	public void addUser(UserBean userBean) {
		try (Connection con = PgAdmin4ConnectionForTodo.getConnection();
				PreparedStatement ptmt = con.prepareStatement(
						"insert into users (user_firstname,user_lastname,user_email,user_password,user_gender,user_que,user_ans) values (?,?,?,?,?,?,?)");) {
			ptmt.setString(1, userBean.getFirstname());
			ptmt.setString(2, userBean.getLastName());
			ptmt.setString(3, userBean.getEmail());
			ptmt.setString(4, userBean.getPassword());
			ptmt.setString(5, userBean.getGender());
			ptmt.setString(6, userBean.getQue());
			ptmt.setString(7, userBean.getAnswer());

			int record = ptmt.executeUpdate();
			System.out.println("Record->" + record);
		} catch (SQLException e) {
			System.out.println("Error -> UserDao -> addUser()");
		}
	}

	public UserBean login(String email, String password) {
		UserBean userBean = null;
		try (Connection con = PgAdmin4ConnectionForTodo.getConnection();
				PreparedStatement ptmt = con
						.prepareStatement("select * from users where user_email=? and user_password=?");) {
			ptmt.setString(1, email);
			ptmt.setString(2, password);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				userBean = new UserBean();
				userBean.setEmail(rs.getString("user_email"));
				userBean.setPassword(rs.getString("user_password"));
				userBean.setUserId(rs.getInt("user_id"));
			}
		} catch (Exception e) {
			System.out.println("Error -> UserDao -> login");
			e.printStackTrace();
		}
		return userBean;
	}

	public UserBean forgotPassword(String email, String Que, String answer) {
		UserBean userBean = null;
		try (Connection con = PgAdmin4ConnectionForTodo.getConnection();
				PreparedStatement ptmt = con
						.prepareStatement("select * from users where user_email=? and user_que=? and user_ans=?");) {
			ptmt.setString(1, email);
			ptmt.setString(2, Que);
			ptmt.setString(3, answer);

			ResultSet rsn = ptmt.executeQuery();
			while (rsn.next()) {
				userBean = new UserBean();
				userBean.setEmail(rsn.getString("user_email"));
				userBean.setQue(rsn.getString("user_que"));
				userBean.setAnswer(rsn.getString("user_ans"));
				userBean.setPassword(rsn.getString("user_password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error ->UserDao -> forgotpassword()");
		}

		return userBean;
	}

	public Boolean updatePassword(String email, String password) {
		boolean flag = false;
		try (Connection con = PgAdmin4ConnectionForTodo.getConnection();
				PreparedStatement ptmt = con.prepareStatement("update users set user_password=? where user_email=?");) {
			ptmt.setString(1, password);
			ptmt.setString(2, email);

			int f = ptmt.executeUpdate();
			if (f == 1) {
				flag = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error -> UserDao -> updatePassword");
		}
		return flag;

	}

	public Boolean emailValidation(String email) {

		boolean flag = false;
		UserBean userBean = null;
		try (Connection con = PgAdmin4ConnectionForTodo.getConnection();
				PreparedStatement ptmt = con.prepareStatement("select * from users where user_email =?");) {
			ptmt.setString(1, email);

			ResultSet rs = ptmt.executeQuery();

			while (rs.next()) {
				userBean = new UserBean();
				userBean.setEmail(email);
			}

			if (userBean == null) {
				flag = true;
			}

		} catch (SQLException e) {
			System.out.println("Error -> UserDao -> emailValidation");
		}

		return flag;
	}
}
