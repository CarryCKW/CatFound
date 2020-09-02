package carry.dao;

import carry.repository.User;

public interface UserDao {
    public User find(String userName);
    void insert(User user);
}
