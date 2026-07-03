package model;

public class Driver extends Person {

    private String vehicleType;
    private String drivingLicense;
    private String vehicleNo;
    private String password;

    public Driver(String name,
            String phone,
            String email,
            String address,
            String vehicleType,
            String drivingLicense,
            String vehicleNo,
            String password) {

        super(name, phone, email, address);

        this.vehicleType = vehicleType;
        this.drivingLicense = drivingLicense;
        this.vehicleNo = vehicleNo;
        this.password = password;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public String getPassword() {
        return password;
    }
}