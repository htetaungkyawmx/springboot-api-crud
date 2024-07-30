package com.jdc.springbootapicrud.dto;

import com.jdc.springbootapicrud.constants.Drink;
import com.jdc.springbootapicrud.constants.Milk;
import com.jdc.springbootapicrud.constants.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineItemDto {

    private UUID id;

    private Drink drink;

    private Size size;

    private Milk milk;
}
