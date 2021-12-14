package Map;

import java.util.HashMap;
import java.util.HashSet;

public class TestHashSetEqualObject {
    public static void main(String[] args) {
        HashSet<User> users = new HashSet<>();
        users.add(new User("1","name1"));
        users.add(new User("1","name1"));
        users.add(new User("1","name1"));

        for (User user : users) {
            System.out.println(user);
        }
    }
}

class User{
    private String id;
    private String name;

    public User(){

    }
    public User(String id,String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(this.id);
    }

    @Override
    public boolean equals(Object obj) {
        User user = (User) obj;
        return this.id == user.id && this.name == user.name;
    }
}
