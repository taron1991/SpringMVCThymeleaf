package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> userList() {
        return userDao.userList();
    }

    @Transactional
    public User addUser(User user){
        return userDao.addUser(user);
    }

    @Transactional
    public void delById(long usserId){
        userDao.delById(usserId);
    }

    public User findById(long userId){
        return userDao.findById(userId);
    }
}
