package web.model;

//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.Size;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Name should note be empty!")
    @Size(min = 2, max = 30, message = "Name should be betwen 2 and 30 characters")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "Name should note be empty!")
    @Size(min = 2, max = 30, message = "Name should be betwen 2 and 30 characters")
    private String lastName;

    @Column(name = "email")
    @NotEmpty(message = "Email should note be empty!")
    @Email(message = "Email should be valid!")
    private String email;

    public User() {
    }

    public User(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
