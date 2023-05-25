package com.crud.CrudDemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

//    @OneToMany(fetch = FetchType.EAGER, targetEntity = Post.class)
//    @JoinColumn(foreignKey = @ForeignKey(name = "fk_category_postid"))
//    private Set<Post> post;
}
