

package com.ghonem.db.op;
import com.ghonem.db.entity.UserEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author gohnem
 */
public class UserOp implements UserList<UserEntity>{
    JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private String sql;
    @Override
    public int insert(UserEntity t) {
        sql="insert into users (user_name , password ) values ('"+ t.getUser_name()+"' , ' "+t.getPassword()+"')";
        return jdbcTemplate.update(sql);
   }

    @Override
    public int update(UserEntity t ) {
        sql="update users set user_name='"+t.getUser_name()+"' , password = '" +t.getPassword()+"' where id = " + t.getId();
        return jdbcTemplate.update(sql);
    }

    @Override
    public int delete(UserEntity t) {
     sql="delete from  users  where id = " + t.getId();
        return jdbcTemplate.update(sql);
   
    }

    @Override
    public List<UserEntity> load() {
      sql="select * from users";
      return jdbcTemplate.query(sql,new RowMapper<UserEntity>(){

        @Override
        public UserEntity mapRow(ResultSet rs, int i) throws SQLException {
        //To change body of generated methods, choose Tools | Templates.
          UserEntity entity=new UserEntity();
           entity.setId(rs.getInt("id"));
           entity.setUser_name(rs.getString("user_name"));
           entity.setPassword(rs.getString("password"));
           return entity;
        }
        
    });
        
        
    }
    
}
