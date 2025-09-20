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


    // Default constructor
    public Tutor() {}

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

    // Getters and Setters
    public Long getId() { return tutorId; }
    public void setId(Long tutorId) { this.tutorId = tutorId; }

    public String getName() { return tutorName; }
    public void setName(String tutorName) { this.tutorName = tutorName; }

    public String getSurname() { return tutorSurname; }
    public void setSurname(String tutorSurname) { this.tutorSurname = tutorSurname; }

    public String getEmail() { return tutorEmail; }
    public void setEmail(String tutorEmail) { this.tutorEmail = tutorEmail; }

    public String getDescription() { return tutorDescription; }
    public void setDescription(String tutorDescription) { this.tutorDescription = tutorDescription; }

    public String getDetail() { return tutorDetail; }
    public void setDetail(String tutorDetail) { this.tutorDetail = tutorDetail; }

    public String getImgUrl() { return imgUrl; }
    public void setImgUrl(String imgUrl) { this.imgUrl = imgUrl; }
}

