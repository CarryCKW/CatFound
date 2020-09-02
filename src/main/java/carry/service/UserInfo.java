package carry.service;

import carry.repository.User;

public interface UserInfo {
    boolean checkPassword(String username,String pwd);
    void addUser(User user);
    boolean isExist(String username);
}
