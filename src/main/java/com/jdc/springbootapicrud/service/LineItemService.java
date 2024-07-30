package com.jdc.springbootapicrud.service;

import com.jdc.springbootapicrud.dto.LineItemDto;
import com.jdc.springbootapicrud.entity.LineItemEntity;

import java.util.List;
import java.util.UUID;

public interface LineItemService {

    LineItemEntity save(LineItemDto lineItemDto);

    List<LineItemEntity> findAll();

    LineItemEntity update(UUID id, LineItemDto lineItemDto);

    void delete(UUID id);

}
