package ru.vicpas.spjs.model;

import java.util.Set;

public class Dto  {


    private Long id;

    private String login;

    private String password;

    private String firstName;

    private String lastName;

    private int level;

    private  Set<String>  rolesInString;



    public Dto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Set<String> getRolesInString() {
        return rolesInString;
    }

    public void setRolesInString(Set<String> rolesInString) {
        this.rolesInString = rolesInString;
    }



    public String getRolesStr(Set<String> set) {
        StringBuilder sb = new StringBuilder();

        for (String role : set) {
            sb.append(role);
            sb.append(" ");
        }
        return sb.toString();
    }


    @Override
    public String toString() {
        return "Dto{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", level=" + level +
                ", rolesInString=" + rolesInString +
                '}';
    }
}
