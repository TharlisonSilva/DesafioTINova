package com.desafio.TiNova.repository;

import com.desafio.TiNova.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Integer> {

    @Query("select max(s.id)+1 from Vehicle s")
    public Integer findMaxId();


    @Query("select s.id from Vehicle s where s.id = ?1")
    public Integer vehicleExists(Integer id);


}
