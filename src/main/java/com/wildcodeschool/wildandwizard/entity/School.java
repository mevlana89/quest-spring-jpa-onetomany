package com.wildcodeschool.wildandwizard.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private Long id_school; //obligé de changer le nom de la variable quand on utilise un table de jointure car hibernate considère l'id ainsi
    private String name;
    private Long capacity;
    private String country;

    //avec le mappedby il associe avec la clé étrangère, si on ne met pas mapped, hibernate créé une table de jointure (classA_classB soit ici Potion_Categorie)
    @OneToMany(mappedBy = "school") //action côté spring

    // Solution avec une table de jointure@joinTable pour table de jointure
    //@OneToMany
    //@JoinTable(name = "school_wizards",joinColumns = @JoinColumn(name="id_school"), inverseJoinColumns = @JoinColumn (name = "id_wizard"))
    private List<Wizard> wizards;

    public School() {
    }

    public List<Wizard> getWizards() {
        return wizards;
    }

    public void setWizards(List<Wizard> wizards) {
        this.wizards = wizards;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}