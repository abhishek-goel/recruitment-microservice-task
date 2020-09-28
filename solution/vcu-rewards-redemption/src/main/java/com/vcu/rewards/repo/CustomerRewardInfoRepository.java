package com.vcu.rewards.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcu.rewards.model.CustomerRewardInfo;
import com.vcu.rewards.model.CustomerRewardInfoId;

@Repository
public interface CustomerRewardInfoRepository extends JpaRepository<CustomerRewardInfo, CustomerRewardInfoId> {
	List<CustomerRewardInfo> findAllByCustomerId(Long customerId);
	CustomerRewardInfo findByCustomerIdAndCreditCardId(Long customerId, Long creditCardId);
}
