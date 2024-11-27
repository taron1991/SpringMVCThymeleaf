package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> userList() {
        return entityManager.createQuery("from User").getResultList();
    }

    public User addUser(User user) {
        entityManager.merge(user);
        return user;
    }

    @Override
    public void delById(long usserId) {
        entityManager.createQuery("delete from User where id=:id").setParameter("id",usserId).executeUpdate();
    }

    public User findById(long userId){
        return entityManager.find(User.class,userId);
    }

}
