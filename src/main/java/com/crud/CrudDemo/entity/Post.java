package com.crud.CrudDemo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(name = "post_desc", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

//    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Category.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "fk_post_categoryid"))
//    private Category category;

    private Boolean isDeleted = false;
}
