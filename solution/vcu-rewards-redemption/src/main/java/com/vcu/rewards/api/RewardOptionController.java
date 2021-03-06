/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.10-SNAPSHOT).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.vcu.rewards.api;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.vcu.rewards.business.RewardOptionService;
import com.vcu.rewards.model.RewardOption;
import com.vcu.rewards.model.Views;
import com.vcu.rewards.repo.RewardOptionRepository;

@RestController
public class RewardOptionController {

	@Autowired
	private RewardOptionRepository rewardOptionRepository;
	
	@Autowired
	private RewardOptionService rewardOptionService;
	
	@GetMapping(value = "/rewardOptions",
    produces = { "application/json" })
    public ResponseEntity<List<RewardOption>> getRewardOptions() {
    	return new ResponseEntity<List<RewardOption>>(rewardOptionRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/rewardOptions/",
    consumes = { "application/json" },
    produces = { "application/json" })
    public ResponseEntity<URI> createRewardOption(@RequestBody @JsonView(Views.PutPost.class) RewardOption rewardOption) throws URISyntaxException {
    	rewardOptionRepository.save(rewardOption);
        return ResponseEntity.created(new URI("/rewardOptions/" + rewardOption.getId())).build();
    }

    @PutMapping(value = "/rewardOptions/{id}",
    consumes = { "application/json" },
    produces = { "application/json" })
    public ResponseEntity<RewardOption> updateRewardOption(@RequestBody @JsonView(Views.PutPost.class) RewardOption rewardOptionIn, @PathVariable Long id) throws URISyntaxException {
        return ResponseEntity.ok(rewardOptionService.updateRewardOption(rewardOptionIn, id));
    }
}