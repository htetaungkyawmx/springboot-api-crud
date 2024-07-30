package com.jdc.springbootapicrud.service.impl;

import com.jdc.springbootapicrud.dto.LineItemDto;
import com.jdc.springbootapicrud.entity.LineItemEntity;
import com.jdc.springbootapicrud.repo.LineItemRepo;
import com.jdc.springbootapicrud.service.LineItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LineItemServiceImpl implements LineItemService {

    @Autowired
    private LineItemRepo lineItemRepo;

    @Override
    public LineItemEntity save(LineItemDto lineItemDto) {

        LineItemEntity lineItemEntity = LineItemEntity
                                        .builder()
                                        .drink(lineItemDto.getDrink())
                                        .size(lineItemDto.getSize())
                                        .milk(lineItemDto.getMilk())
                                        .build();

        return lineItemRepo.save(lineItemEntity);
    }

    @Override
    public List<LineItemEntity> findAll() {
        return lineItemRepo.findAll();
    }

    @Override
    public LineItemEntity update(UUID id, LineItemDto lineItemDto) {
        LineItemEntity lineItemEntity = lineItemRepo.findById(id).orElseThrow(() -> new RuntimeException("LineItem not found"));
        lineItemEntity.setDrink(lineItemDto.getDrink());
        lineItemEntity.setSize(lineItemDto.getSize());
        lineItemEntity.setMilk(lineItemDto.getMilk());
        return lineItemRepo.save(lineItemEntity);
    }

    @Override
    public void delete(UUID id) {
        lineItemRepo.deleteById(id);
    }

}
