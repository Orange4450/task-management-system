package com.Boltabay_Zhaniya.taskmanagement.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "comments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Boltabay_Zhaniya_Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Boltabay_Zhaniya_Task task;
}
