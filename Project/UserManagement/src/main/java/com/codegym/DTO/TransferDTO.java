package com.codegym.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public @Data class TransferDTO {
    private int id;
    private int idSender;
    private int idReceive;
    private float amountReceive;
    private int feesPercent;
    private float feesAmount;
    private String nameSender;
    private String nameReceive;

    public TransferDTO(int idSender, int idReceive, float amountReceive, int feesPercent, float feesAmount, String nameSender, String nameReceive) {
        this.idSender = idSender;
        this.idReceive = idReceive;
        this.amountReceive = amountReceive;
        this.feesPercent = feesPercent;
        this.feesAmount = feesAmount;
        this.nameSender = nameSender;
        this.nameReceive = nameReceive;
    }
}
