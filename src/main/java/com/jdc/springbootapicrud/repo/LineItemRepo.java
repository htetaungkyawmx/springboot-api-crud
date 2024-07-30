package com.jdc.springbootapicrud.repo;

import com.jdc.springbootapicrud.entity.LineItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LineItemRepo extends JpaRepository<LineItemEntity, UUID> {

}
