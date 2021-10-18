package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;

public class StudentDao {

	private JdbcTemplate jdbc;

	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	public Boolean save(final Student s) {
		String str = "insert into student values(?,?,?,?,?,?,?,?,?)";
		return jdbc.execute(str, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, s.getEnrollment_id());
				ps.setString(2, s.getFirst_name());
				ps.setString(3, s.getLast_name());
				ps.setString(4, s.getGender());
				ps.setString(5, s.getDob());
				ps.setString(6, s.getState());
				ps.setString(7, s.getCourse());
				ps.setString(8, s.getMarks());
				ps.setString(9, s.getDoa());

				return ps.execute();
			}

		});
	}

	public List display() {
		final List list = new ArrayList();
		String str = "select * from student";
		jdbc.query(str, new ResultSetExtractor<Student>() {

			@Override
			public Student extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next())

				{
					Student obj = new Student();
					obj.setEnrollment_id(rs.getInt(1));
					obj.setFirst_name(rs.getString(2));
					obj.setLast_name(rs.getString(3));
					obj.setGender(rs.getString(4));
					obj.setDob(rs.getString(5));
					obj.setState(rs.getString(6));
					obj.setMarks(rs.getString(7));
					obj.setCourse(rs.getString(8));
					obj.setDoa(rs.getString(9));

					list.add(obj);
				}
				return null;
			}

		});
		return list;
	}

	public List search(Student s) {
		final List list = new ArrayList();
		String str = "select * from student where state='" + s.getState() + "' and course='" + s.getCourse() + "'";
		jdbc.query(str, new ResultSetExtractor<Student>() {

			@Override
			public Student extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					Student obj = new Student();
					obj.setEnrollment_id(1);
					obj.setFirst_name(rs.getString(2));
					obj.setLast_name(rs.getString(3));
					obj.setGender(rs.getString(4));
					obj.setDob(rs.getString(5));
					obj.setState(rs.getString(6));
					obj.setMarks(rs.getString(7));
					obj.setCourse(rs.getString(8));
					obj.setDoa(rs.getString(9));
					list.add(obj);

				}
				return null;
			}

		});
		return list;
	}

	public List update(final Student s) {
		String str = "update student set first_name=?,last_name=?,gender=?,dob=?,state=?,marks=?,course=?,doa=? where enrollment_id=?";
		jdbc.execute(str, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, s.getFirst_name());
				ps.setString(2, s.getLast_name());
				ps.setString(3, s.getGender());
				ps.setString(4, s.getDob());
				ps.setString(5, s.getState());
				ps.setString(6, s.getMarks());
				ps.setString(7, s.getCourse());
				ps.setString(8, s.getDoa());
				ps.setInt(9, s.getEnrollment_id());
				return ps.execute();

			}

		});
		List list = display();
		return list;
	}

	public List delete(Student s) {
		String str = "delete from student where enrollment_id='" + s.getEnrollment_id() + "'";
		jdbc.update(str);
		List list = display();
		return list;
	}
}
