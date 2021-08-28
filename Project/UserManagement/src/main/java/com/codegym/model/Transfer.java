package com.codegym.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "transfers")
@NoArgsConstructor
@AllArgsConstructor
public @Data class Transfer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_sender")
    @NotBlank
    private int idSender;

    @Column(name = "id_receive")
    @NotBlank
    private int idReceive;

    @Column(name = "amount_receive")
    @NotBlank
    private float amountReceive;

    @Column(name = "fees_percent")
    @NotBlank
    private int feesPercent;

    @Column(name = "fees_amount")
    @NotBlank
    private float feesAmount;
}
