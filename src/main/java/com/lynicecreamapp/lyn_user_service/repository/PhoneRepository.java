package com.lynicecreamapp.lyn_user_service.repository;

import com.lynicecreamapp.lyn_user_service.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone,Long>{
    Phone findByLocalNumber(long localNumber);
}
