package com.desafio.TiNova.service;

import com.desafio.TiNova.entity.Vehicle;
import com.desafio.TiNova.repository.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private IVehicleRepository IVehicleRepository;

    @Transactional
    public String createVehicle(Vehicle vehicle){
        try {
            if (IVehicleRepository != null){
                vehicle.setId(null == IVehicleRepository.findMaxId()? 1 : IVehicleRepository.findMaxId() + 1);
                IVehicleRepository.save(vehicle);
                return "Vehicle record created successfully.";
            }else {
                return "Vehicle already exists in the database.";
            }
        }catch (Exception e){
            throw e;
        }
    }

    public List<Vehicle> getVehicles(){
        return IVehicleRepository.findAll();
    }

    public Optional<Vehicle> getVehicles(Integer id){
        return IVehicleRepository.findById(id);
    }

    @Transactional
    public String updateVehicle(Vehicle vehicle){

        if (IVehicleRepository.vehicleExists(vehicle.getId()) != null){
            try {
                Vehicle item = IVehicleRepository.findById(vehicle.getId()).get();
                item.setveiculo(vehicle.getveiculo() != null && vehicle.getveiculo() != "" ? vehicle.getveiculo(): item.getveiculo());
                item.setMarca(vehicle.getMarca() != null && vehicle.getMarca() != "" ? vehicle.getMarca(): item.getMarca());
                item.setAno(vehicle.getAno() != null && vehicle.getAno() != 0 ? vehicle.getAno(): item.getAno());
                item.setDescricao(vehicle.getDescricao() != null && vehicle.getDescricao() != "" ? vehicle.getDescricao(): item.getDescricao());
                item.setVendido(vehicle.isVendido());
                item.setUpdated(new Date());
                IVehicleRepository.save(item);
                return "vehicle record updated.";
            }catch (Exception e){
                throw e;
            }
        }else {
            return "vehicle does not exists in the database.";
        }
    }

    @Transactional
    public String deleteVehicle(Integer id){

        if (IVehicleRepository.vehicleExists(id) != null){
            try {
                IVehicleRepository.deleteById(id);
                return "Vehicle record deleted successfully.";
            }catch (Exception e){
                throw e;
            }

        }else {
            return "Vehicle does not exist";
        }

    }
}
