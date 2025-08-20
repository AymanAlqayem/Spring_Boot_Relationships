package com.tarifI.oneToOne;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    // cascade = CascadeType.ALL → when you save/delete a User,
    // the related Profile is also saved/deleted.

    // @JoinColumn → tells Hibernate where the foreign key is.
    // name = "profile_id" → column name in the users table
    // referencedColumnName = "id" → column in the profiles table it points to
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;

    public User() {
    }

    public User(Long id, String username, Profile profile) {
        this.id = id;
        this.username = username;
        this.profile = profile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}