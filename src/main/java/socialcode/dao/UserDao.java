package socialcode.dao;

import socialcode.model.User;

public interface UserDao {

	User findByUserId(int id);

}
