package app.service;


import app.dao.UserDao;
import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    public List<User> getUsers(){
        return userDao.getUsers();
    }

    @Transactional(readOnly = true)
    public User getUser(int id){
        return userDao.findById(id);
    }


    public void saveUser (User user){
        userDao.saveUser(user);
    }


    public void updateUser (User user){
        userDao.updateUser(user);
    }


    public void deleteUsers(Integer id){
        userDao.deleteUser(id);
    }
}