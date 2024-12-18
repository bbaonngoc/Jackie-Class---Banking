package service.service_interface;//  Lớp giao diện (interface layer) giữa người dùng và chương trình -> hiển thị menu và nhận lệnh từ người dùng.

import model.User;

import java.util.List;

public interface UserService {

    // add user CRUD --> void
    void addUser(User user);

    // update model.User
    User UpdateUser(User user, String id);

    // find model.User
    User findUser(String id);

    // find users
    List<User> findUsers();

    //remove urser
    void removeUser (User user);

}
