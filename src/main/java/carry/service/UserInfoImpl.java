package carry.service;

import carry.dao.UserDao;
import carry.repository.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserInfoImpl implements UserInfo{

    @Autowired
    private UserDao userDao;

    @Override
    public boolean checkPassword(String username, String pwd) {
        User user = userDao.find(username);
        String password = user.getPassword();
        if(password.equals(pwd)){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void addUser(User user) {
        userDao.insert(user);
    }

    @Override
    public boolean isExist(String username) {
        return false;
    }

}
