package com.railway.helloworld.models;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    private Long id;
    private String username;
    private String email;


    @Column(nullable = false)
    private String password;



    private String firstName;
    private String lastName;

    // Example relationships
    // @OneToMany(mappedBy = "user")
    // private Set<Blog> blogs;

    // @ManyToMany
    // @JoinTable(
    //     name = "user_following",
    //     joinColumns = @JoinColumn(name = "user_id"),
    //     inverseJoinColumns = @JoinColumn(name = "blog_id")
    // )
    // private Set<Blog> following;

    // Getters and setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
}