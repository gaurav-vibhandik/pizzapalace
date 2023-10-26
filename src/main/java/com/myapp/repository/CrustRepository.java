package com.myapp.repository;


import com.myapp.model.Crust;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CrustRepository {

    List<Crust> getAllCrustDetails();


}
