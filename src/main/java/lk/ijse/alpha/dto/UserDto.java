package lk.ijse.alpha.dto;

public class UserDto {
    private String userId;
    private String userName;
    private String email;
    private String password;
    private String contact;
    private String address;
    private String role;

    public UserDto() {
    }

    public UserDto(String userId, String useeName, String email, String password, String contact, String address, String role) {
        this.userId = userId;
        this.userName = useeName;
        this.email = email;
        this.password = password;
        this.contact = contact;
        this.address = address;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String toString() {
        return "UserDto{" + "userId=" + userId + ", useeName=" + userName + ", email=" + email + ", password=" + password + ", contact=" + contact + ", address=" + address + ", role=" + role + '}';
    }
}
