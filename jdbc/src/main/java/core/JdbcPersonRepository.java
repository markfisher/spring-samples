package core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

@Repository
public class JdbcPersonRepository implements PersonRepository {

	private final JdbcTemplate jdbcTemplate;

	private final PersonMapper personMapper = new PersonMapper();

	@Autowired
	private JdbcPersonRepository(DataSource dataSource) {
		Assert.notNull(dataSource, "DataSource is required");
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int count() {
		return this.jdbcTemplate.queryForInt("select count(*) from people");
	}

	public List<Person> getAll() {
		return this.jdbcTemplate.query("select * from people", personMapper);
	}

	public void add(Person person) {
		this.jdbcTemplate.update("insert into people (name) values (:name)", person.getName());
	}


	private static class PersonMapper implements RowMapper<Person> {

		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Person(rs.getString("name"));
		}
	}

}
