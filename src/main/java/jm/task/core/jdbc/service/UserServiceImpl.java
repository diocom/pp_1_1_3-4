package jm.task.core.jdbc.service;
import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao daojdbc = new UserDaoJDBCImpl();

    public void createUsersTable() {
        daojdbc.createUsersTable();
    }

    public void dropUsersTable() {
        daojdbc.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        daojdbc.saveUser(name, lastName, age);
        System.out.println("User c именем - " + name + " добавлен в базу данных");
    }

    public void removeUserById(long id) {
        daojdbc.removeUserById(id);
    }

    public List<User> getAllUsers() {
        List<User> allusers = daojdbc.getAllUsers();
        for (User usr : allusers) {
            System.out.println(usr);
        }
        return allusers;
    }

    public void cleanUsersTable() {
        daojdbc.cleanUsersTable();
    }
}
