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
public class HistoricalOrder {
    @Id
    @SequenceGenerator(name="historical_order_sequence",sequenceName = "historical_order_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "historical_order_sequence")
    @Column
    private int id;

    @Column
    private String details;

    @Column
    private String orderType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
}
