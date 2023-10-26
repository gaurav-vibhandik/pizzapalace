package com.myapp.repository;

import com.myapp.model.CrustInventory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CrustInventoryRepository {
    List<CrustInventory> getCrustInventoryDetails();

}
