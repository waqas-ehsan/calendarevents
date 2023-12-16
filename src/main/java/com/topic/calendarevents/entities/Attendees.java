package com.topic.calendarevents.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "attendees" , uniqueConstraints= @UniqueConstraint(columnNames={"email"}))
public class Attendees implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ATTENDEE_ID")
    private Long attendeeId;
    @NonNull
    private String name;
    private String email;
}
