package org.ubt.chat.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Supporter {

    @Id
    @SequenceGenerator(name = "supporter_sequence", sequenceName = "supporter_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supporter_sequence")
    @Column
    private long id;

    @Column
    private String firstName;

    @Column
    private String lastName;
}
