package com.vcu.rewards.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="CustomerRewardInfo")
@IdClass(CustomerRewardInfoId.class)
public class CustomerRewardInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="CustomerId")
    private Long customerId;

	@Id
	@Column(name="CreditCardId")
    private Long creditCardId;
    
    @Column(name="RewardType")
    private RewardType rewardType;

    @Column(name="RewardBalance")
    private Double rewardBalance;

    @Column(name="LastRedemptionDate")
    private LocalDate lastRedemptionDate;
}
