package model;

public class User extends Person {

    private String password;

    public User()
    {

    }

    public User(String name, String phone, String email, String address, String password)
    {
        super(name,phone,email,address);
        this.password=password;
    }

    
    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password=password;
    }

}