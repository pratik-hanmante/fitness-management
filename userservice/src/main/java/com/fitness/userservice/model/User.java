package com.fitness.userservice.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * Entity class representing a User in the system.
 * Maps to the "users" table in the database.
 */
@Entity
@Table(name = "users")
@Data // Lombok annotation to generate getters, setters, toString, equals, and hashCode
public class User {

    /**
     * Primary key for the User entity.
     * Uses UUID generation strategy for unique string-based IDs.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    /**
     * User's email address.
     * Must be unique and cannot be null.
     */
    @Column(unique = true, nullable = false)
    private String email;

    /**
     * User's password.
     * Cannot be null.
     */
    @Column(nullable = false)
    private String password;

    /**
     * User's first name.
     */
    private String firstName;

    /**
     * User's last name.
     */
    private String lastName;

    /**
     * Enum representing the role of the user.
     * Stored as a string in the database.
     * Defaults to USER role.
     */
    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;

    /**
     * Timestamp of when the user was created.
     * Automatically populated by Hibernate.
     */
    @CreationTimestamp
    private LocalDateTime createdAt;

    /**
     * Timestamp of when the user was last updated.
     * Automatically updated by Hibernate.
     */
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
