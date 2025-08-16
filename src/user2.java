package CA_project_2;

public class user2 {
    private String fullName;
    private String email;
    private String phone;
    private String college;
    private String city;

    public user2(String fullName, String email, String phone, String college, String city) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.college = college;
        this.city = city;
    }

    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getCollege() { return college; }
    public String getCity() { return city; }
}
