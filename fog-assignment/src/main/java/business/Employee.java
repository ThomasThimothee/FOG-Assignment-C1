package business;

/**
 *
 * @author Lovro
 */
public class Employee {

    private int employeeId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    public Employee(String username, String password, String firstName, String lastName, String phone, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int id) {
        this.employeeId = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
