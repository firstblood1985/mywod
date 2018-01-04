package com.limin.mywod.entity.published_workout;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.limin.mywod.entity.user.User;
import com.limin.mywod.entity.workout.WorkoutType;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by CBB on 17/12/14.
 */
@Entity
@Table(name="PUBLISHED_WORKOUT")
public class PublishedWorkout {

    @Id
    @Column(name="PUBLISHED_WORKOUT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="NAME")
    private String name;

   @Column(name="TYPE")
   @Enumerated(EnumType.STRING)
    private WorkoutType type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PUBLISHED_BY", nullable = false)
    @JsonIgnoreProperties({"joinedAffiliates","ownedAffiliates"})
    private User publisher;

    @Column(name="PUBLISHED_DATE")
    @Type(type="date")
    private Date publishedDate;

    @Column(name="RX_VERSION")
    private String rxVersion;

    @Column(name="SCALE_VERSION1")
    private String scaleVersion1;

    @Column(name="SCALE_VERSION2")
    private String scaleVersino2;

    @Column(name="IS_BENCHMARK")
    @Type(type="yes_no")
    private boolean isBenchmark;



    @Column(name="IS_DELETED")
    @Type(type="yes_no")
    private boolean isDeleted;

    @Column(name="COMMENT")
    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public WorkoutType getType() {
        return type;
    }

    public void setType(WorkoutType type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getPublisher() {
        return publisher;
    }

    public void setPublisher(User publisher) {
        this.publisher = publisher;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getRxVersion() {
        return rxVersion;
    }

    public void setRxVersion(String rxVersion) {
        this.rxVersion = rxVersion;
    }

    public String getScaleVersion1() {
        return scaleVersion1;
    }

    public void setScaleVersion1(String scaleVersion1) {
        this.scaleVersion1 = scaleVersion1;
    }

    public String getScaleVersino2() {
        return scaleVersino2;
    }

    public void setScaleVersino2(String scaleVersino2) {
        this.scaleVersino2 = scaleVersino2;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public boolean isBenchmark() {
        return isBenchmark;
    }

    public void setBenchmark(boolean benchmark) {
        isBenchmark = benchmark;
    }
}
