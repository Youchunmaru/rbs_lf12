package de.rbsulm.rbs_lf12.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Entity
public class CalendarEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String title;
    private String description;
    private String location;
    @Column(nullable = false)
    private Long startDate;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CalendarCategory category;
}
