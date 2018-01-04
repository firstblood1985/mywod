package com.limin.mywod.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.limin.mywod.entity.affiliate.Affiliate;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by CBB on 17/12/14.
 */
@Entity
@Table(name="USER")
public class User {

    @Id
    @Column(name="USER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="LOGIN")
    private String login;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="EMAIL")
    private String email;

    @Column(name="PHONE")
    private String phone;

    @Column(name="IS_ADMIN")
    @Type(type="yes_no")
    private boolean isAdmin;

    @Column(name="IS_DELETED")
    @Type(type="yes_no")
    private boolean isDeleted;

    @ManyToMany(mappedBy = "owners")
    @JsonIgnoreProperties("owners")
    private Set<Affiliate> ownedAffiliates;

    @ManyToMany(mappedBy = "members")
    @JsonIgnoreProperties("members")
    private Set<Affiliate> joinedAffiliates;

    public Set<Affiliate> getJoinedAffiliates() {
        return joinedAffiliates;
    }

    public void setJoinedAffiliates(Set<Affiliate> joinedAffiliates) {
        this.joinedAffiliates = joinedAffiliates;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Set<Affiliate> getOwnedAffiliates() {
        return ownedAffiliates;
    }

    public void setOwnedAffiliates(Set<Affiliate> ownedAffiliates) {
        this.ownedAffiliates = ownedAffiliates;
    }
}
