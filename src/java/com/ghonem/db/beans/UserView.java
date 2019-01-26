package com.ghonem.db.beans;

import com.ghonem.db.entity.UserEntity;
import com.ghonem.db.op.UserList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author gohnem
 */
@ApplicationScoped
@ManagedBean(name = "u")
public class UserView {

    private UserList userList;
    private UserEntity ue;
    private String user_name;
    private String password;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private List<UserEntity> allUser;
    private ApplicationContext context;

    @PostConstruct
    public void init() {
        context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserView userView = (UserView) context.getBean("userView");
        allUser = new ArrayList<UserEntity>();
        allUser = userView.userList.load();
    }

    public List<UserEntity> getAllUser() {

        return allUser;
    }

    public void setAllUser(List<UserEntity> allUser) {

        this.allUser = allUser;
    }

    public void addUser() {
        UserView userView = (UserView) context.getBean("userView");
        ue = new UserEntity();
        ue.setPassword(password);
        ue.setUser_name(user_name);
        userView.userList.insert(ue);
        allUser = userView.userList.load();
    }

    public void update() {
        UserView userView = (UserView) context.getBean("userView");
        ue = new UserEntity();
        ue.setId(id);
        ue.setPassword(password);
        ue.setUser_name(user_name);
        userView.userList.update(ue);
        allUser = userView.userList.load();

    }

    public void delete() {
        UserView userView = (UserView) context.getBean("userView");
        ue = new UserEntity();
        ue.setId(id);
        ue.setPassword(password);
        ue.setUser_name(user_name);
        userView.userList.delete(ue);
        allUser = userView.userList.load();

    }

    public UserList getUserList() {
        return userList;
    }

    public void setUserList(UserList userList) {
        this.userList = userList;
    }

    public UserEntity getUe() {
        return ue;
    }

    public void setUe(UserEntity ue) {
        this.ue = ue;
    }

}
