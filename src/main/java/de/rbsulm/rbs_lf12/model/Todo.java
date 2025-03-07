package de.rbsulm.rbs_lf12.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String title;
    private String description;
    private Date dueDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public String getDueDateString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dueDate.toLocalDate().format(formatter);
    }
}
