package com.jdc.springbootapicrud.entity;

import com.jdc.springbootapicrud.constants.Drink;
import com.jdc.springbootapicrud.constants.Milk;
import com.jdc.springbootapicrud.constants.Size;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LineItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Drink drink;

    private Size size;

    private Milk milk;

    //1.parameter count
    //2.data type order

}
