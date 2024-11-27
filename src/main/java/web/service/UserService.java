package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> userList();

    User addUser(User user);

    void delById(long usserId);

    User findById(long userId);
}
