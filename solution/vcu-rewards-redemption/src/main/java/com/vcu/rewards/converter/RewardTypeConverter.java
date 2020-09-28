package com.vcu.rewards.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.springframework.util.StringUtils;

import com.vcu.rewards.model.RewardType;

@Converter(autoApply = true)
public class RewardTypeConverter implements AttributeConverter<RewardType, String> {
 
    @Override
    public String convertToDatabaseColumn(RewardType rewardType) {
        return StringUtils.capitalize(rewardType.name().toLowerCase());
    }
 
    @Override
    public RewardType convertToEntityAttribute(String dbData) {
        return RewardType.valueOf(dbData.toUpperCase());
    }
}