package com.example.trello.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "task_categories")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TaskCategories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
}
