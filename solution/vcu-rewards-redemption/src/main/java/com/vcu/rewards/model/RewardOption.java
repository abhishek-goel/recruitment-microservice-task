package com.vcu.rewards.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Entity
@Data
@Table(name="RewardOption")
public class RewardOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
	@JsonView(Views.Get.class)
    private Long id;
    
    @Column(name="Value")
	@JsonView(Views.PutPost.class)
    private Double value;

    @Column(name="ExpirationDate")
	@JsonView(Views.PutPost.class)
    private LocalDate expirationDate;

    @Column(name="Description")
	@JsonView(Views.PutPost.class)
    private String description;
    
    @Column(name="RewardType")
	@JsonView(Views.PutPost.class)
    private RewardType rewardType;
}
