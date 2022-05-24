package org.ubt.profile.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Recommendation {
    @Id
    @SequenceGenerator(name="recommendation_sequence",sequenceName = "recommendation_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "recommendation_sequence")
    @Column
    private int id;

    @Column
    private boolean notInterested;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
}
