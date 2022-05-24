package org.ubt.profile.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ubt.profile.common.enums.Feedback;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supporter {
    private int id;
    private String employeeId;
    private List<Feedback> feedback;
}
