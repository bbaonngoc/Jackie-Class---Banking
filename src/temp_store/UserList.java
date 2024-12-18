package temp_store;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private List<User> users = new ArrayList<>();

    //constructor
    public UserList() {}
    public UserList(List<User> users) {
        this.users = users;
    }

    // getter & setter
    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }

    private void display (String message) {
        System.out.println(message);
    }

    public void addUser (User newUser) {
        users.add(newUser);
    }

    private void removeUser (User user) {
        if (users.isEmpty()) {
            users.remove(user);
        } else {
            display("User not found");
        }
    }

}
