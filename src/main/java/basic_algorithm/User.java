package basic_algorithm;

public class User {
    String name;
    int password = 0;
    String email = "@";
    int age;
    String gender;

    public void changePass(int password){
        this.password=password;
    }
    public void changeEmail(String email){
        this.email=email;
    }
    public User(){}
    public User (String name,  int age, String gender){
        this.name=name;
        this.age=age;
        this.gender=gender;
    }
}
class Admin extends User {

}
class Guest extends User {
    @Override
    public void changePass(int password){
        System.out.println("You can't change password. Type: Guest");
    }
    @Override
    public void changeEmail(String email){
        System.out.println("You can't change email. Type: Guest");
    }
}

class LocalUser extends User {
    @Override
    public void changePass(int password){
        System.out.println("You can't change password. Type: Guest");
    }
}

class RemoteUser extends User{

}