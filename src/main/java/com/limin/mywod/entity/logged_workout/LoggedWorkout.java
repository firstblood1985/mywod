package com.limin.mywod.entity.logged_workout;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.limin.mywod.entity.published_workout.PublishedWorkout;
import com.limin.mywod.entity.user.User;
import org.hibernate.annotations.Type;
import com.limin.mywod.util.DurationToStringConverter;

import javax.persistence.*;
import java.time.Duration;
import java.util.Date;

@Entity
@Table(name="LOGGED_WORKOUT")
public class LoggedWorkout {


    @Id
    @Column(name="LOGGED_WORKOUT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="PUBLISHED_WORKOUT_ID",nullable = false)
    private PublishedWorkout publishedWorkout;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LOGGED_BY", nullable = false)
    @JsonIgnoreProperties({"joinedAffiliates","ownedAffiliates"})
    private User loggedBy;

    @Column(name="LOGGED_DATE")
    @Type(type="date")
    private Date loggedDate;

    @Column(name="RESULTS")
    private String Results;

    @Column(name="DURATION")
    @Convert(converter=DurationToStringConverter.class)
    private Duration duration;

    @Column(name="SETS")
    private int sets;

    @Column(name="REPS")
    private int reps;

    @Column(name="COMMENTS")
    private String comments;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PublishedWorkout getPublishedWorkout() {
        return publishedWorkout;
    }

    public void setPublishedWorkout(PublishedWorkout publishedWorkout) {
        this.publishedWorkout = publishedWorkout;
    }

    public User getLoggedBy() {
        return loggedBy;
    }

    public void setLoggedBy(User loggedBy) {
        this.loggedBy = loggedBy;
    }

    public Date getLoggedDate() {
        return loggedDate;
    }

    public void setLoggedDate(Date loggedDate) {
        this.loggedDate = loggedDate;
    }

    public String getResults() {
        return Results;
    }

    public void setResults(String results) {
        Results = results;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}
