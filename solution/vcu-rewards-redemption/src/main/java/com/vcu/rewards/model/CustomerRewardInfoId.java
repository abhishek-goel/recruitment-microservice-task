package com.vcu.rewards.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class CustomerRewardInfoId implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long customerId;
    private Long creditCardId;
}