package com.carlosjr.backproposal.proposal;

import com.carlosjr.backproposal.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Double requestValue;
    private Integer paymentTerm;
    private Boolean approved;
    private Boolean integrated;
    private String obs;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id" )
    private User user;

}
