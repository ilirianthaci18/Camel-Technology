package org.ubt.profile.common.mappers;

import org.modelmapper.ModelMapper;
import org.ubt.profile.common.dto.RecommendationDTO;
import org.ubt.profile.common.dto.RecommendationDTOUser;;
import org.ubt.profile.model.Recommendation;

import static org.ubt.profile.common.mappers.UserMapper.toUserDTORecommendation;

public class RecommendationMapper {
    private static ModelMapper modelMapper = new ModelMapper();

    public static RecommendationDTO toRecommendationDTO(Recommendation recommendation) {
        RecommendationDTO recommendationDTO = modelMapper.map(recommendation, RecommendationDTO.class);

        recommendationDTO.setId(recommendation.getId());
//        recommendationDTO.setNotInterested(recommendation.isNotInterested());
//        recommendationDTO.setUser(toUserDTORecommendation(recommendation.getUser()));

        return recommendationDTO;
    }

    public static RecommendationDTOUser toRecommendationDTOUser(Recommendation recommendation) {
        RecommendationDTOUser recommendationDTOUser = modelMapper.map(recommendation, RecommendationDTOUser.class);

//        recommendationDTOUser.setNotInterested(recommendation.isNotInterested());

        return recommendationDTOUser;
    }
}
