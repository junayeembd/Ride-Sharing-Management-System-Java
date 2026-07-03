package model;

public class Admin extends Person {

    private String adminId;
    private String password;

    public Admin(String name,
            String phone,
            String email,
            String address,
            String password,
            String adminId) {

        super(name, phone, email, address);

        this.password = password;
        this.adminId = adminId;
    }

    public String getAdminId() {
        return adminId;
    }

    public String getPassword() {
        return password;
    }

    public void displayAdminInfo() {

        System.out.println("\n===== Admin Information =====");

        System.out.println("Admin ID: " + adminId);
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
    }
}