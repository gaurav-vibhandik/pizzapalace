package com.myapp.repository;


import com.myapp.model.Crust;
import com.myapp.model.Topping;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ToppingRepository {

    int createTopping(@Param("tp")Topping topping);

    int updateTopping( @Param("tpId") String tpId,@Param("tp")Topping topping);
    int deleteTopping(@Param("tpId")String toppingId);
    List<Topping> getToppingDetails();

    Topping getToppingDetailsById( @Param("tpId") String tpId);


}
