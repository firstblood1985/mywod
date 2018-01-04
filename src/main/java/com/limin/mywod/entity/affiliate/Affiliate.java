package com.limin.mywod.entity.affiliate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.limin.mywod.entity.user.User;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by CBB on 17/12/14.
 *
 */
@Entity
@Table(name="AFFILIATE")
public class Affiliate {

    @Id
    @Column(name="AFFILIATE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long affiliateId;

    @Column(name="NAME")
    private String name;

    @Column(name="ADDRESS")
    private String address;

    @ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinTable(name = "OWN_AFFILIATE", joinColumns = @JoinColumn(name = "AFFILIATE_ID", referencedColumnName = "AFFILIATE_ID"), inverseJoinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID"))
    @JsonIgnoreProperties("ownedAffiliates")
    private Set<User> owners;

    @ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinTable(name = "JOIN_AFFILIATE", joinColumns = @JoinColumn(name = "AFFILIATE_ID", referencedColumnName = "AFFILIATE_ID"), inverseJoinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID"))
    @JsonIgnoreProperties("joinedAffiliates")
    private Set<User> members;

    public Set<User> getMembers() {
        return members;
    }

    public void setMembers(Set<User> members) {
        this.members = members;
    }

    public Set<User> getOwners() {
        return owners;
    }

    public void setOwners(Set<User> owners) {
        this.owners = owners;
    }

    public long getAffiliateId() {

        return affiliateId;
    }

    public void setAffiliateId(long affiliateId) {
        this.affiliateId = affiliateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
