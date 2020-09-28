package com.vcu.rewards.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.vcu.rewards.model.RewardOption;
import com.vcu.rewards.repo.RewardOptionRepository;

@Service
public class RewardOptionService {

	@Autowired
	private RewardOptionRepository rewardOptionRepository;

	public RewardOption updateRewardOption(RewardOption rewardOptionIn, Long id) {
		RewardOption rewardOption = rewardOptionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("RewardOption not found for this id :: " + id));
    	rewardOption.setExpirationDate(rewardOptionIn.getExpirationDate());
    	rewardOption.setDescription(rewardOptionIn.getDescription());
    	rewardOption.setRewardType(rewardOptionIn.getRewardType());
    	rewardOption.setValue(rewardOptionIn.getValue());
    	rewardOptionRepository.save(rewardOption);
    	return rewardOption;
    }

}
