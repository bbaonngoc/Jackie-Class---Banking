package service;
//lop XU LI NGHIEP VU -> thuc hien cac chuc nang QUAN LI DU LIEU nguoi dung
// -> Them + lay thong tin + xoa + hien thi danh sach tat ca nguoi dung
// Mục đích: Tách biệt các xử lý nghiệp vụ khỏi giao diện người dùng, giúp dễ bảo trì và mở rộng chương trình.

import model.User;
import temp_store.UserList;

import java.util.List;

public class UserServiceImpl implements service.service_interface.UserService {

    // object
    UserList userList = new UserList();

    // tao mot danh sach va gan list user o userList cho no
    List<User> users = userList.getUsers();

    @Override
    public void addUser(User user) {
        userList.addUser(user);
        System.out.println("Added finish.");
    }

    @Override
    public User UpdateUser(User user, String id) {
        for (User u : users) {
            if (u.getUserId().equals(id)) {
                u.setUserName(u.getUserName());
                u.setUserName(u.getUserName());
                u.setEmail(u.getEmail());
                u.setPhoneNumber(u.getPhoneNumber());
                u.setBankAccount(u.getBankAccount());
                return u;
            }
        }
        System.out.println("ID not found");
        return null;
    }

    @Override
    public User findUser(String id) {
        for (User u : users) {
            if (u.getUserId().equals(id)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public List<User> findUsers() {
        if (users.isEmpty()) {
            System.out.println("List users not found");
        }
        return users;
    }

    @Override
    public void removeUser(User user) {
        if (users.remove(user)) {
            System.out.println("User removed");
        } else {
            System.out.println("User not found");
        }
    }

}
