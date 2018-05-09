package com.pranshu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.pranshu.model.Employee;
import com.pranshu.util.DbUtil;

public class EmployeeDao {

	private Connection connection;

	public EmployeeDao() {
		connection = DbUtil.getConnection();
	}

	public void addEmployee(Employee employee) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT into hexaware_employees (name, mobile, dept) values (?, ?, ?)");
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setLong(2, employee.getMobile());
			preparedStatement.setString(3, employee.getDept());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteEmployee(int id) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from hexaware_employees where id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Employee> searchEmployeeById(Employee employee) {
		PreparedStatement preparedstatement = null;
		List<Employee> searchEmployeeResults = new ArrayList<Employee>();
		try {
			preparedstatement = connection.prepareStatement("SELECT * FROM hexaware_employees where id = ?");
			preparedstatement.setInt(1, employee.getId());

			ResultSet resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				employee.setId(resultset.getInt("id"));
				employee.setName(resultset.getString("name"));
				employee.setMobile(resultset.getLong("mobile"));
				employee.setDept(resultset.getString("dept"));
				searchEmployeeResults.add(employee);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchEmployeeResults;
	}

	public List<Employee> searchEmployeeByName(Employee employee) {
		PreparedStatement preparedstatement = null;
		List<Employee> searchEmployeeResults = new ArrayList<Employee>();

		try {
			preparedstatement = connection
					.prepareStatement("SELECT * FROM hexaware_employees where lower(name) like ?");
			preparedstatement.setString(1, employee.getName().replaceAll("'", "''") + "%");
			ResultSet resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				employee.setId(resultset.getInt("id"));
				employee.setName(resultset.getString("name"));
				employee.setMobile(resultset.getLong("mobile"));
				employee.setDept(resultset.getString("dept"));
				searchEmployeeResults.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchEmployeeResults;
	}

	public List<Employee> searchEmployeeByMobile(Employee employee) {
		PreparedStatement preparedstatement = null;
		List<Employee> searchEmployeeResults = new ArrayList<Employee>();

		try {
			preparedstatement = connection.prepareStatement("SELECT * FROM hexaware_employees where mobile = ?");
			preparedstatement.setLong(1, employee.getMobile());

			ResultSet resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				employee.setId(resultset.getInt("id"));
				employee.setName(resultset.getString("name"));
				employee.setMobile(resultset.getLong("mobile"));
				employee.setDept(resultset.getString("dept"));
				searchEmployeeResults.add(employee);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchEmployeeResults;
	}

	public List<Employee> searchEmployeeByDept(Employee employee) {
		PreparedStatement preparedstatement = null;
		List<Employee> searchEmployeeResults = new ArrayList<Employee>();

		try {
			preparedstatement = connection
					.prepareStatement("SELECT * FROM hexaware_employees where lower(dept) like ?");
			preparedstatement.setString(1, employee.getDept().replaceAll("'", "''") + "%");

			ResultSet resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				employee.setId(resultset.getInt("id"));
				employee.setName(resultset.getString("name"));
				employee.setMobile(resultset.getLong("mobile"));
				employee.setDept(resultset.getString("dept"));
				searchEmployeeResults.add(employee);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchEmployeeResults;
	}

	public void updateEmployee(Employee employee) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE hexaware_employees set name=?, mobile=?, dept=?" + "where id=?");
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setLong(2, employee.getMobile());
			preparedStatement.setString(3, employee.getDept());
			preparedStatement.setInt(4, employee.getId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery("select * from hexaware_employees");
			while (resultset.next()) {
				Employee employee = new Employee();
				employee.setId(resultset.getInt("id"));
				employee.setName(resultset.getString("name"));
				employee.setMobile(resultset.getLong("mobile"));
				employee.setDept(resultset.getString("dept"));
				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employees;
	}

	public Employee getId(int id) {
		Employee employee = new Employee();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from hexaware_employees where id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultset = preparedStatement.executeQuery();

			if (resultset.next()) {
				employee.setId(resultset.getInt("id"));
				employee.setName(resultset.getString("name"));
				employee.setMobile(resultset.getLong("mobile"));
				employee.setDept(resultset.getString("dept"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

}
