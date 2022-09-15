package org.ubt.profile.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table
public class Recommendation {
    @Id
    @SequenceGenerator(name = "recommendation_sequence", sequenceName = "recommendation_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recommendation_sequence")
    @Column
    private Long id;

    @Column
    @NonNull
    private String email;

    @NonNull
    @ElementCollection
    @CollectionTable(name="productCodes",joinColumns = @JoinColumn(name="email"))
    @Column(name="product_codes")
    private List<String> productCodes;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    private User user;
//
//    @JsonManagedReference
//    public User getUser() {
//        return user;
//    }

}
