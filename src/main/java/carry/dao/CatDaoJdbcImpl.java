package carry.dao;

import carry.ExtException.FailedException;
import carry.repository.Cat;
import carry.repository.CatPicture;
import carry.repository.Variety;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class CatDaoJdbcImpl implements CatDao {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;



    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate);
    }

    @Override
    public void insert(Cat cat) {
        String sql = null;
        PreparedStatementCreatorFactory creatorFactory = new PreparedStatementCreatorFactory("insert into " +
                "catlist(weight,name,adopted,description,birthTime)values (?,?,?,?,?)",new int[]{Types.DOUBLE,Types.CHAR,
                Types.BOOLEAN, Types.CHAR,Types.DATE});
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int count = jdbcTemplate.update(creatorFactory.newPreparedStatementCreator(new Object[]{cat.getWeight(),cat.getName(),cat.getAdopted(),
                cat.getDescription(),cat.getBirthTime()}),keyHolder);
        if(count!=1){
            throw new FailedException("Can Not Insert Cat");
        }

    }

    @Override
    public void update(Cat cat) {
        int count = jdbcTemplate.update("update catlist set (weight,name,adopted,description,birthTime) = (?,?,?,?,?) where id = ?",
                cat.getWeight(),cat.getName(),cat.getAdopted(), cat.getDescription(),cat.getBirthTime(),cat.getId());
        if(count!=1){
            throw new FailedException("Can Not Update Cat");
        }
    }

    @Override
    public void delete(long catId) {
        int count = jdbcTemplate.update("delete catlist where id = ?",catId);
        if(count!=1){
            throw new FailedException("Can Not Delete Cat");
        }
    }

    @Override
    public List<Cat> findAll() {
        String sql = "select * from catlist";
        List<Cat> list = jdbcTemplate.query(sql, new RowMapper<Cat>() {
            @Override
            public Cat mapRow(ResultSet resultSet, int i) throws SQLException {
                Cat cat = new Cat();
                cat.setId(resultSet.getLong("id"));
                cat.setWeight(resultSet.getDouble("weight"));
                cat.setAdopted(resultSet.getBoolean("adopted"));
                cat.setDescription(resultSet.getString("description"));
                cat.setName(resultSet.getString("name"));
                cat.setBirthTime(resultSet.getDate( "birthTime"));
                return cat;
            }
        });
        return list;
    }

    @Override
    public void update(final List<Cat> cats) {
        int[] counts = jdbcTemplate.batchUpdate("update catlist set (weight,name,adopted,description,birthTime) = (?,?,?,?,?) where id = ?",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                        Cat cat = cats.get(i);
                        preparedStatement.setDouble(1,cat.getWeight());
                        preparedStatement.setString(2,cat.getName());
                        preparedStatement.setBoolean(3,cat.getAdopted());
                        preparedStatement.setString(4,cat.getDescription());
                        preparedStatement.setDate(5,cat.getBirthTime());
                        preparedStatement.setLong(6,cat.getId());
                    }

                    @Override
                    public int getBatchSize() {
                        return cats.size();
                    }
                });
        int i=1;
        for(int count:counts){
            if(count!=1){
                throw new FailedException("Can Not Update Cat No." + i);
            }
            i++;
        }
    }

    @Override
    public Cat find(long catId) {
        String sql = "select id,weight,name,adopted,description,birthTime from catlist where id = ?";
        return this.jdbcTemplate.queryForObject(sql, new Object[]{catId}, new RowMapper<Cat>() {
            @Override
            public Cat mapRow(ResultSet resultSet, int i) throws SQLException {
                Cat cat = new Cat();
                cat.setId(resultSet.getLong("id"));
                cat.setWeight(resultSet.getDouble("weight"));
                cat.setAdopted(resultSet.getBoolean("adopted"));
                cat.setDescription(resultSet.getString("description"));
                cat.setName(resultSet.getString("name"));
                cat.setBirthTime(resultSet.getDate( "birthTime"));
                return cat;
            }
        });
    }

    @Override
    public List<Cat> find(List<Long> catIds) {
        String sql = "select * from catlist where id in (:catIds)";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("catIds",catIds);
        return this.namedParameterJdbcTemplate.query(sql, sqlParameterSource, new RowMapper<Cat>() {
            @Override
            public Cat mapRow(ResultSet resultSet, int i) throws SQLException {
                Cat cat = new Cat();
                cat.setId(resultSet.getLong("id"));
                cat.setWeight(resultSet.getDouble("weight"));
                cat.setAdopted(resultSet.getBoolean("adopted"));
                cat.setDescription(resultSet.getString("description"));
                cat.setName(resultSet.getString("name"));
                cat.setBirthTime(resultSet.getDate( "birthTime"));
                return cat;
            }
        });
    }

    @Override
    public List<Cat> find(Variety variety) {
        return null;
    }

    @Override
    public CatPicture findCatPicture(final long catId) {
        String sql = "select id,blob from catpicturelist where id = ?";
        return this.jdbcTemplate.queryForObject(sql, new Object[]{catId}, new RowMapper<CatPicture>() {
            @Override
            public CatPicture mapRow(ResultSet resultSet, int i) throws SQLException {
                CatPicture catPicture = new CatPicture();
                catPicture.setId(resultSet.getLong("id"));
                catPicture.setBlob(resultSet.getBlob("blob"));
                return catPicture;
            }
        });
    }

    @Override
    public List<Cat> findByLimit(int startCursor, int endCursor) {
        return null;
    }
}
