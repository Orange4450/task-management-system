package com.Boltabay_Zhaniya.taskmanagement.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Boltabay_Zhaniya_Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String status;

    private String priority;

    private LocalDate deadline;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Boltabay_Zhaniya_Project project;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Boltabay_Zhaniya_User assignedUser;
}
