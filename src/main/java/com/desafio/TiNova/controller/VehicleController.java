package com.desafio.TiNova.controller;



import com.desafio.TiNova.entity.Vehicle;
import com.desafio.TiNova.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info(){
        return "The application is up...";
    }

    @RequestMapping(value = "veiculos", method = RequestMethod.GET)
    public List<Vehicle> getVehicles(){
        return vehicleService.getVehicles();
    }

    @RequestMapping(value = "veiculos/{id}", method = RequestMethod.GET)
    public Optional<Vehicle> getVehicleForId(@PathVariable(value = "id") int id){
        return vehicleService.getVehicles(id);
    }

/*
    METODO COM PROBLEMAS NA DEFINIÇÃO DO DOCUMENTO
    @RequestMapping(value = "veiculos", params = { "marca", "ano" }, method = RequestMethod.GET)
    @ResponseBody
    public List<Vehicle> getVehicleForMarcaAndAno(@RequestParam("marca") String pr1,
                                                  @RequestParam("ano") Integer pr2){
        return vehicleService.getVehicles(pr1, pr2);
    }
*/

    @RequestMapping(value = "veiculos", method = RequestMethod.POST)
    public String createVehicle(@RequestBody Vehicle student){
        return vehicleService.createVehicle(student);
    }

    @RequestMapping(value = "veiculos/{id}", method = RequestMethod.PUT)
    public String updateVehicle(@PathVariable(value = "id") Integer id,
                                @RequestBody Vehicle vehicle){
        vehicle.setId(id);
        return vehicleService.updateVehicle(vehicle);
    }

    @RequestMapping(value = "veiculos/{id}", method = RequestMethod.PATCH)
    public String updateVehicleSingleParam(@PathVariable(value = "id") Integer id,
                                           @RequestBody Vehicle vehicle){
        vehicle.setId(id);
        return vehicleService.updateVehicle(vehicle);
    }

    @RequestMapping(value = "veiculos/{id}", method = RequestMethod.DELETE)
    public String deleteVehicle(@PathVariable(value = "id") Integer id){
        return vehicleService.deleteVehicle(id);
    }
}
