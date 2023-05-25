package com.crud.CrudDemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE category  SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=false")
@FilterDef(name = "deletedPostFilter", parameters = @ParamDef(name = "isDeleted", type = Boolean.class))
@Filter(name = "deletedPostFilter", condition = "is_deleted = :isDeleted")

//@FilterDef(name = "deletedProductFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
//@Filter(name = "deletedProductFilter", condition = "deleted = :isDeleted")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    private Boolean isDeleted = false;

//    @OneToMany(fetch = FetchType.EAGER, targetEntity = Post.class)
//    @JoinColumn(foreignKey = @ForeignKey(name = "fk_category_postid"))
//    private Set<Post> post;
}
