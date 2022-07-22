package ism.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ism.bean.TaskBean;
import ism.util.PgAdmin4ConnectionForTodo;

public class TaskDao {
	public void addTask(TaskBean taskBean) {

		try (Connection con = PgAdmin4ConnectionForTodo.getConnection();
				PreparedStatement ptmt = con.prepareStatement(
						"insert into tasks (task_name,task_description,status,prority,start_date,end_date,userid) values (?,?,?,?,?,?,?)");) {

			ptmt.setString(1, taskBean.getTaskName());
			ptmt.setString(2, taskBean.getTaskDescription());
			ptmt.setString(3, taskBean.getStatus());
			ptmt.setString(4, taskBean.getPrority());
			ptmt.setString(5, taskBean.getStartDate());
			ptmt.setString(6, taskBean.getEndDate());
			ptmt.setInt(7, taskBean.getUserid());

			int record = ptmt.executeUpdate();
			System.out.println("Record Task->" + record);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error -> TaskDao -> addTask()");
		}

	}

	public ArrayList<TaskBean> listTasks(int userId) {

		ArrayList<TaskBean> task = new ArrayList<>();
		try (Connection con = PgAdmin4ConnectionForTodo.getConnection();
				PreparedStatement ptmt = con.prepareStatement("select * from tasks where userid = ? ");) {
			
			ptmt.setInt(1, userId);
//			ptmt.setString(2, status);
			
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				TaskBean taskBean = new TaskBean();
				System.out.println("Hello"+rs.getString("task_name"));
				taskBean.setTaskName(rs.getString("task_name"));
				taskBean.setTaskDescription(rs.getString("task_description"));
				taskBean.setStatus(rs.getString("status"));
				taskBean.setPrority(rs.getString("prority"));
				taskBean.setStartDate(rs.getString("start_date"));
				taskBean.setEndDate(rs.getString("end_date"));
				taskBean.setTaskid(rs.getInt("task_id"));
				task.add(taskBean);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error -> TaskDao -> listTask()");
		}

		return task;
	}
	
	public Boolean taskDone(int taskId) {
		boolean flag=false;
		try (Connection con = PgAdmin4ConnectionForTodo.getConnection();
				PreparedStatement ptmt = con.prepareStatement("update tasks set status=? where task_id=?");) {
				
			ptmt.setString(1, "done");
			ptmt.setInt(2, taskId);
			
			int f=ptmt.executeUpdate();
			if(f==1) {
				flag=true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error -> TaskDao -> taskDone()");
		}

	return flag;
	}
	
	public boolean deleteTask(int taskId) {
		boolean flag=false;
		try (Connection con = PgAdmin4ConnectionForTodo.getConnection();
				PreparedStatement ptmt = con.prepareStatement("delete from tasks where task_id =?");) {
			ptmt.setInt(1, taskId);
			
			int f;
			f = ptmt.executeUpdate();
			
			if(f==1) {
				flag=true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error -> TaskDao -> deleteTask()");
		}
		return flag;
	}
	
	public TaskBean updateTaskUseingTaskId(int taskId) {
		TaskBean taskBean = null;
		try (Connection con = PgAdmin4ConnectionForTodo.getConnection();
				PreparedStatement ptmt = con.prepareStatement("select * from tasks where task_id = ? ");) {
			
			ptmt.setInt(1, taskId);
//			ptmt.setString(2, status);
			
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				taskBean = new TaskBean();
				
				taskBean.setTaskName(rs.getString("task_name"));
				taskBean.setTaskDescription(rs.getString("task_description"));
				taskBean.setStatus(rs.getString("status"));
				taskBean.setPrority(rs.getString("prority"));
				taskBean.setStartDate(rs.getString("start_date"));
				taskBean.setEndDate(rs.getString("end_date"));
				taskBean.setTaskid(rs.getInt("task_id"));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error -> TaskDao -> updateTaskUseingTaskId()");
		}

		return taskBean;
	}
	
	public Boolean submitUpdateTask(TaskBean taskBean) {
		boolean flag=false;
		try (Connection con = PgAdmin4ConnectionForTodo.getConnection();
				PreparedStatement ptmt = con.prepareStatement("update tasks set task_name=?,task_description=?,status=?,prority=?,start_date=?,end_date=?,userid=? where task_id=?");) {
				
			
			ptmt.setString(1, taskBean.getTaskName());
			ptmt.setString(2, taskBean.getTaskDescription());
			ptmt.setString(3, taskBean.getStatus());
			ptmt.setString(4, taskBean.getPrority());
			ptmt.setString(5, taskBean.getStartDate());
			ptmt.setString(6, taskBean.getEndDate());
			ptmt.setInt(7, taskBean.getUserid());
			ptmt.setInt(8, taskBean.getTaskid());
			
			int f=ptmt.executeUpdate();
			if(f==1) {
				flag=true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error -> TaskDao -> taskDone()");
		}

	return flag;
	}
}
