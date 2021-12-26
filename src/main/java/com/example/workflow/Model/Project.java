package com.example.workflow.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private int workforce;
    private String supervisorName;
    private String owner;
    private int hoursPerWeek;
    private boolean isAvailable = true;

    public Project(String title, int maxNumberOfStudent, String supervisorName, String companyName, int requiredHoursPerWeek) {
        this.title = title;
        this.workforce = maxNumberOfStudent;
        this.supervisorName = supervisorName;
        this.owner = companyName;
        this.hoursPerWeek = requiredHoursPerWeek;
    }

    public Project(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWorkforce() {
        return workforce;
    }

    public void setWorkforce(int workforce) {
        this.workforce = workforce;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(int hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}


