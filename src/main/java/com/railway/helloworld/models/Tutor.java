package com.railway.helloworld.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tutor")
public class Tutor {

    @Id
    @Column(name = "tutorId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tutorId;
    @Column(name = "name")
    private String tutorName;
    @Column(name = "surname")
    private String tutorSurname;
    @Column(name = "email")
    private String tutorEmail;
    @Column(name = "description")
    private String tutorDescription;
    @Column(name = "detail")
    private String tutorDetail;
    private String imgUrl;


    public Tutor(String tutorName, String tutorSurname, String tutorEmail, String tutorDescription, String imgUrl) {
        this.tutorName = tutorName;
        this.tutorSurname = tutorSurname;
        this.tutorEmail = tutorEmail;
        this.tutorDescription = tutorDescription;
        this.imgUrl = imgUrl;
    }

    public Tutor(String tutorDetail) {
        this.tutorDetail = tutorDetail;
    }
}

