package com.manish.tinyUrlApp.data.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "url_mapping")
@Getter
@Setter
public class UrlEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "tiny_url_key")
    private String key;
    @Column(name = "original_url")
    private String originalUrl;
    @Column(name = "expiry_date")
    private Date expiryDate;
    @CreatedDate
    @Column(name = "created_date")
    private Date createdDate;
    @LastModifiedDate
    @Column(name = "updated_date")
    private Date updatedDate;
    @Column(name = "user_id")
    private Long userId;
}
