package com.example.bankingapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "account")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Account {

    @Id
    @Field("accountNumber")
    private String accountNumber;
    private String accountHolderName;
    private String ifscCode;
    private Double balance;
    private User user;

}
