package za.ac.cput.ecommerce.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    private String userId;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private String PhoneNumber;
    private String address;


    protected User() {

    }
    public User (Builder builder){
        this.userId = builder.userId;
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.email = builder.email;
        this.password = builder.password;
        this.PhoneNumber = builder.PhoneNumber;
        this.address = builder.address;

    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static class Builder {
        private String userId;
        private String lastName;
        private String firstName;
        private String email;
        private String password;
        private String PhoneNumber;
        private String address;

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }
        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }
        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }
        public Builder setPhoneNumber(String PhoneNumber) {
            this.PhoneNumber = PhoneNumber;
            return this;
        }
        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }
        public User build() {
            return new User(this);
        }
    }//end class
}// end main
