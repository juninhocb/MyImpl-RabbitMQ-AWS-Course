package com.carlosjr.backproposal.user;

import com.carlosjr.backproposal.proposal.Proposal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String lastName;
    private String cpf;
    private String phone;
    private Double rent;
    @OneToOne(mappedBy = "user")
    private Proposal proposal;
}
