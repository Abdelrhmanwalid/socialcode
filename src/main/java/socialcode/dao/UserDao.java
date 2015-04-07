package socialcode.dao;

import socialcode.model.User;

public interface UserDao {

	User findByUserEmail(String email);

}
