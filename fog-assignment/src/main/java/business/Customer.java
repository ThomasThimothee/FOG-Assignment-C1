package business;

/**
 *
 * @author Lovro
 */
public class Customer {

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Customer(String email, String password, String firstName, String lastName, String address, String phone) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
    }
    private int id_customer;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    

  @Override
public String toString() {
    return "Email: " + this.getEmail()+ 
           ", Password: " + this.getPassword() +
            ", First Name: " + this.getFirstName() +
            ", Last Name: " + this.getLastName()+
            ", Address: " + this.getAddress()+
            ", Phone Number: " + this.getPhone();
}
}

