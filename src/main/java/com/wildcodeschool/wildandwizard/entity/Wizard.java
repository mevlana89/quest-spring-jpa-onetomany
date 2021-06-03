package com.wildcodeschool.wildandwizard.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Wizard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // private Long id_wizard; //obligé de changer le nom de la variable quand on utilise un table de jointure car hibernate considère l'id ainsi
    private String firstName;
    private String lastName;
    private Date birthday;
    private String birthPlace;
    private String biography;
    private boolean muggle;


    @ManyToOne /*(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH , optional = false)*/ //pour optional action côté BDD si pas créé puis côté spring

    //    //@JoinColumn(name = "test_id") // par défaut nomClass_id   // action côté BDD
    //TEST
    //@JoinColumn(nullable = false)
    // Solution avec une table de jointure table de jointure
   // @JoinTable(name = "school_wizards",joinColumns = @JoinColumn(name="id_wizard"), inverseJoinColumns = @JoinColumn (name = "id_school"))
    private School school;

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Wizard() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public boolean isMuggle() {
        return muggle;
    }

    public void setMuggle(boolean muggle) {
        this.muggle = muggle;
    }


}