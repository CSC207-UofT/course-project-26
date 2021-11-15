package main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User2 {
    @Id
    private String username;

    @Column
    private String password;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String address;

    public User2() {

    }

    public User2(String username, String firstName, String lastName, String email, String address) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
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

    public String getEmail() { return email; }

    public void setAd(String email) {
        this.email = email;
    }

    public String getAddress() { return address; }

    public void setAddress(String address) {
        this.address = address;
    }


    public static User2Builder builder() {
        return new User2Builder();
    }

    public static class User2Builder {

        private String username;

        private String password;

        private String firstName;

        private String lastName;

        private String email;

        private String address;

        public User2Builder username(final String username) {
            this.username = username;
            return this;
        }

        public User2Builder firstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        public User2Builder lastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        public User2Builder email(final String email) {
            this.email = email;
            return this;
        }

        public User2Builder address(final String address) {
            this.address = address;
            return this;
        }


        public User2 build() {
            return new User2(username, firstName, lastName, email, address);
        }

    }
}
