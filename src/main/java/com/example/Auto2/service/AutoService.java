package com.example.Auto2.service;

import com.example.Auto2.controller.request.InfoForAuto;
import com.example.Auto2.dao.AutosList;
import com.example.Auto2.dto.car.Auto;
import com.example.Auto2.dto.car.AutoAlreadyExists;
import com.example.Auto2.dto.car.AutoNotFound;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AutoService {
    AutosList autorepository;
    Map<Integer, ArrayList<Auto>> selectedcars=new HashMap<Integer, ArrayList<Auto>>();

     public void CreateCollectionofCars(Integer id) {
         selectedcars.put(id,new ArrayList<Auto>());
     }
     public void ClearCollection() {
            selectedcars.clear();
     }

     public ArrayList<Auto> GetCars(Integer id) {
     return     selectedcars.get(id);
     }
     public void CreateNewAuto(InfoForAuto info, Integer id) {

     Auto addedauto= new Auto(info.getSpeed(), info.getPower(), info.getFuelСonsumption(), info.isAWD(), info.getSizeofVehicleBase(),info.getPrice(),info.getAcceleration(),info.getBrandModel());
     if (selectedcars.containsKey(id)) {
         ArrayList<Auto> autos=selectedcars.get(id);
         autos.add(addedauto);
         selectedcars.put(id,autos);
         return;
     }
     ArrayList<Auto> autos=new ArrayList<>();
         autos.add(addedauto);
         selectedcars.put(id,autos);
     }

     public Auto AddAutotoRepository(InfoForAuto info) throws AutoAlreadyExists {
         try {
             FindAutoinRepository(info.getBrandModel());
         } catch (AutoNotFound exception) {
             Auto addedauto = new Auto(info.getSpeed(), info.getPower(), info.getFuelСonsumption(), info.isAWD(), info.getSizeofVehicleBase(), info.getPrice(), info.getAcceleration(), info.getBrandModel());
         return     autorepository.insert(addedauto);
         }
         throw new AutoAlreadyExists("Auto already exists");

     }

     public Auto FindAutoinRepository(String brandmodel ) throws AutoNotFound {
      Optional<Auto> elem= autorepository.findFirstByBrandModel(brandmodel);
       if(elem.isEmpty()) {
           throw new AutoNotFound("Auto not found");
       }
       return elem.get();
     }


    public AutoService(AutosList autorepository) {
        this.autorepository = autorepository;
    }
}
