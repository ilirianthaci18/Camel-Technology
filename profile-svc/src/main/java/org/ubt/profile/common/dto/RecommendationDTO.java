package org.ubt.profile.common.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationDTO {
    private Long id;

    private boolean notInterested;

    private UserDTORecommendation user;

    @JsonManagedReference
    public UserDTORecommendation getUser() {
        return user;
    }
}
