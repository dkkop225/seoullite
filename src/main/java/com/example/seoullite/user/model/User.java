package com.example.seoullite.user.model;

import lombok.Data;

import javax.persistence.*;

// @Data 어노테이션 : https://blog.naver.com/PostView.nhn?blogId=writer0713&logNo=221260111429&parentCategoryNo=&categoryNo=83&viewDate=&isShowPopularPosts=false&from=postView
@Entity
@Data
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="user_no")
    private Long userNo;

    @Column(name="user_id")
    private String userId;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="user_name")
    private String userName;
}
