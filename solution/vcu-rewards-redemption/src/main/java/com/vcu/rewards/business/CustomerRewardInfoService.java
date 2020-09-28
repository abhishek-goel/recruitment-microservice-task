package com.vcu.rewards.business;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.vcu.rewards.model.CustomerRewardInfo;
import com.vcu.rewards.model.RewardOption;
import com.vcu.rewards.model.RewardType;
import com.vcu.rewards.repo.CustomerRewardInfoRepository;
import com.vcu.rewards.repo.RewardOptionRepository;

@Service
public class CustomerRewardInfoService {

	@Autowired
	private RewardOptionRepository rewardOptionRepository;

	@Autowired
	private CustomerRewardInfoRepository customerRewardInfoRepository;
	
	public List<RewardOption> getAllAvailableRewards(Long customerId) {
		List<CustomerRewardInfo> customerRewards = customerRewardInfoRepository.findAllByCustomerId(customerId);
		MultiValueMap<RewardType, Double> customerRewardTypeAndBalance = new LinkedMultiValueMap<RewardType, Double>();
		
		for (CustomerRewardInfo customerRewardInfo : customerRewards) {
			customerRewardTypeAndBalance.add(customerRewardInfo.getRewardType(), customerRewardInfo.getRewardBalance());
		}
		
		List<RewardOption> rewardOptions = rewardOptionRepository.findAllByRewardTypeInAndExpirationDateGreaterThanEqual(customerRewardTypeAndBalance.keySet(), LocalDate.now());
		rewardOptions.removeIf(rewardOption -> (rewardOption.getValue() > customerRewardTypeAndBalance.get(rewardOption.getRewardType()).stream().mapToDouble(distance -> distance).min().getAsDouble()));
		return rewardOptions;
	}

	public void redeemReward(Long customerId, Long creditCardId) {
		CustomerRewardInfo customerRewardInfo = customerRewardInfoRepository.findByCustomerIdAndCreditCardId(customerId, creditCardId);
		List<RewardOption> rewardOptions = rewardOptionRepository.findAllByRewardTypeAndValueLessThanEqualAndExpirationDateGreaterThanEqual(customerRewardInfo.getRewardType(), customerRewardInfo.getRewardBalance(), LocalDate.now());
		rewardOptions.sort(Comparator.comparing(RewardOption::getValue).reversed());
		
		customerRewardInfo.setLastRedemptionDate(LocalDate.now());
		customerRewardInfo.setRewardBalance(customerRewardInfo.getRewardBalance() - rewardOptions.get(0).getValue());
		customerRewardInfoRepository.save(customerRewardInfo);
	}
}
