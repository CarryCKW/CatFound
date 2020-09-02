package carry.dao;

import carry.ExtException.FailedException;
import carry.repository.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class UserDaoJdbcImpl implements UserDao {


    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate);
    }


    @Override
    public User find(final String userName) {
        String sql = "select name,password from userlist where name = ?";
        return this.jdbcTemplate.queryForObject(sql, new Object[]{userName}, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        });
    }

    @Override
    public void insert(User user) {
        PreparedStatementCreatorFactory creatorFactory = new PreparedStatementCreatorFactory("insert into userlist(name," +
                "password) values (?,?)",new int[]{Types.CHAR,Types.CHAR});
        int count = jdbcTemplate.update(creatorFactory.newPreparedStatementCreator(new Object[]{user.getName(),user.getPassword()}));
        if (count!=1){
            throw new FailedException("Can Not Insert User");
        }
    }
}
