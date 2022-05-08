package com.sudhakar.api.Entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="notestable")
@Data
public class Note {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String body;

    private String description;

    @Column(name="createdAt", nullable = false,updatable = false)
    @CreationTimestamp
    private Date createdAt;

    @Column(name="updatedAt")
    @UpdateTimestamp
    private Date updatedAt;
}
