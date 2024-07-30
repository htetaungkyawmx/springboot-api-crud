package com.jdc.springbootapicrud.controller;

import com.jdc.springbootapicrud.dto.LineItemDto;
import com.jdc.springbootapicrud.entity.LineItemEntity;
import com.jdc.springbootapicrud.service.LineItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class LineItemController {

    @Autowired
    private LineItemService lineItemService;

    @PostMapping("/create")
    public ResponseEntity<LineItemDto> create(@RequestBody LineItemDto lineItemDto) {

        lineItemService.save(lineItemDto);

        return new ResponseEntity<>(lineItemDto, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<LineItemEntity>> getAll() {
        List<LineItemEntity> lineItems = lineItemService.findAll();
        return new ResponseEntity<>(lineItems, HttpStatus.OK);
    }

    @PutMapping("/update1")
    public ResponseEntity<LineItemEntity> update1(@RequestParam("id") UUID id, @RequestBody LineItemDto lineItemDto) {
        LineItemEntity updatedLineItem = lineItemService.update(id, lineItemDto);
        return new ResponseEntity<>(updatedLineItem, HttpStatus.OK);
    }

    @PutMapping("/update2/{id}")
    public ResponseEntity<LineItemEntity> update2(@PathVariable("id") UUID id, @RequestBody LineItemDto lineItemDto) {
        LineItemEntity updatedLineItem = lineItemService.update(id, lineItemDto);
        return new ResponseEntity<>(updatedLineItem, HttpStatus.OK);
    }

    @PutMapping("/update3/{id}")
    public ResponseEntity<LineItemEntity> update3(
            @PathVariable("id") UUID id,
            @RequestParam("detail") String detail,
            @RequestBody LineItemDto lineItemDto) {

        LineItemEntity updatedLineItem = lineItemService.update(id, lineItemDto);
        return new ResponseEntity<>(updatedLineItem, HttpStatus.OK);
    }

    @PutMapping("/update4/{id}")
    public ResponseEntity<LineItemEntity> update4(
            @RequestParam("detail") String detail,
            @PathVariable("id") UUID id,
            @RequestBody LineItemDto lineItemDto) {

        LineItemEntity updatedLineItem = lineItemService.update(id, lineItemDto);
        return new ResponseEntity<>(updatedLineItem, HttpStatus.OK);
    }

    @PutMapping("/update5")
    public ResponseEntity<LineItemEntity> update5(@RequestParam("id") UUID id, @RequestParam("fruit") String fruit, @RequestBody LineItemDto lineItemDto) {
        LineItemEntity updatedLineItem = lineItemService.update(id, lineItemDto);
        return new ResponseEntity<>(updatedLineItem, HttpStatus.OK);
    }

    @PutMapping("/update6/{id}/{fruit}")
    public ResponseEntity<LineItemEntity> update6(@PathVariable("id") UUID id, @PathVariable("fruit") String fruit, @RequestBody LineItemDto lineItemDto) {
        LineItemEntity updatedLineItem = lineItemService.update(id, lineItemDto);
        return new ResponseEntity<>(updatedLineItem, HttpStatus.OK);
    }

    @PutMapping("/update7")
    public ResponseEntity<LineItemEntity> update7(@RequestParam("id") UUID id, @RequestParam(value = "fruit", required = false, defaultValue = "watermelon") String fruit, @RequestBody LineItemDto lineItemDto) {
        LineItemEntity updatedLineItem = lineItemService.update(id, lineItemDto);
        return new ResponseEntity<>(updatedLineItem, HttpStatus.OK);
    }

    @PutMapping( {"/update8/{id}", "/update8/{id}/{fruit}"})
    public ResponseEntity<LineItemEntity> update8(@PathVariable("id") UUID id, @PathVariable(value = "fruit", required = false) String fruit, @RequestBody LineItemDto lineItemDto) {
        LineItemEntity updatedLineItem = lineItemService.update(id, lineItemDto);
        return new ResponseEntity<>(updatedLineItem, HttpStatus.OK);
    }

    @PutMapping( {"/update9/{id}", "/update9/{id}/{fruit}"})
    public ResponseEntity<LineItemEntity> update9(@PathVariable("id") UUID id, @PathVariable(value = "fruit") Optional<String> fruit, @RequestBody LineItemDto lineItemDto) {
        LineItemEntity updatedLineItem = lineItemService.update(id, lineItemDto);
        String data = fruit.orElse("default1");
        return new ResponseEntity<>(updatedLineItem, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam UUID id) {
        lineItemService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
