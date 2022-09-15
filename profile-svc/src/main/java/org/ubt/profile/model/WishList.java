package org.ubt.profile.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class WishList {
    @Id
    @SequenceGenerator(name = "wishlist_sequence", sequenceName = "wishlist_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wishlist_sequence")
    @Column
    private Long id;

    @NonNull
    @ElementCollection
    @CollectionTable(name="product_code",joinColumns = @JoinColumn(name="userId"))
    @Column(name="product_codes")
    private List<String> details;

    @NonNull
    @Column
    private String userId;

//    @Column
//    private double valueOfWishList;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "user_wishlist_id"))
//    private User user;
//
//    @JsonManagedReference
//    public User getUser() {
//        return user;
//    }

}
