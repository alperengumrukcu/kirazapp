package com.kiraz.kirazapp.model;

import com.kiraz.kirazapp.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "comment",uniqueConstraints = {@UniqueConstraint(columnNames = {"users_id","adverts_id"})})
public class Comment extends BaseEntity {
    @Column
    private String comment;
    @ManyToOne
    private Users users;
    @ManyToOne
    private Adverts adverts;

    private int score;
}
