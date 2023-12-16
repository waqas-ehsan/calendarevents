package com.topic.calendarevents.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "event" , uniqueConstraints= @UniqueConstraint(columnNames={"name"}))
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="EVENT_ID")
    private int eventId;
    @NonNull
    private String name;
    private Instant date;
    //uni-directional one-to-many association to Attendees
    @OneToMany(cascade = CascadeType.ALL ,orphanRemoval = true)
    @JoinColumn(name="EVENT_ID")
    private List<Attendees> attendees;
    private String notification;
}
