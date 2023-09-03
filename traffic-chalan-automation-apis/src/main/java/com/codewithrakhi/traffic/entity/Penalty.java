package com.codewithrakhi.traffic.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter

public class Penalty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int penaltyId;

    private int fineAmount;

    private String penaltyType;

    @ManyToOne
    private User user;


}
