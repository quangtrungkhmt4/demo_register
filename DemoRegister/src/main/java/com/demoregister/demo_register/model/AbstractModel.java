package com.demoregister.demo_register.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Column(name = "created_at")
//    private Long createdAt;
//
//    @Column(name = "updated_at")
//    private Long updatedAt;
//
//    public AbstractModel(){
//        createdAt = System.currentTimeMillis();
//        updatedAt = System.currentTimeMillis();
//    }

}
