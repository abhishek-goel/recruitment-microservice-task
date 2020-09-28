package com.vcu.rewards.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcu.rewards.model.RewardOption;
import com.vcu.rewards.model.RewardType;

@Repository
public interface RewardOptionRepository extends JpaRepository<RewardOption, Long> {
	
	List<RewardOption> findAllByRewardTypeInAndExpirationDateGreaterThanEqual(Iterable<RewardType> rewardTypes,
			LocalDate expirationDate);

	List<RewardOption> findAllByRewardTypeAndValueLessThanEqualAndExpirationDateGreaterThanEqual(RewardType rewardType,
			Double rewardBalance, LocalDate now);

}
