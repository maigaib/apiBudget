package com.apiBudget.apiBudget.Repository;

import com.apiBudget.apiBudget.Modeles.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeRepository extends JpaRepository<Type,Long> {
    Type findTypeById(Long id);

}
