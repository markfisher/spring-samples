package core;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

public class JdbcPersonRepository implements PersonRepository {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	private JdbcPersonRepository(DataSource dataSource) {
		Assert.notNull(dataSource, "DataSource is required");
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int count() {
		return jdbcTemplate.queryForInt("select count(*) from people");
	}

}
