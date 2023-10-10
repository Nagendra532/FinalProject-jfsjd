package com.example.Grocery.Repository;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Grocery.entity.MyGroceryList;



@Repository
public interface MyGroceryRepository extends JpaRepository<MyGroceryList,Long>{

}