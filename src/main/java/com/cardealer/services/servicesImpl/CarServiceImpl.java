package com.cardealer.services.servicesImpl;

import com.cardealer.domain.dtos.json.CarImportJSONDto;
import com.cardealer.domain.dtos.json.CarsAndPartsExportJSONDto;
import com.cardealer.domain.dtos.xml.CarExportXMLDto;
import com.cardealer.domain.dtos.xml.CarsExportXMLDto;
import com.cardealer.domain.entities.Car;
import com.cardealer.domain.entities.Part;
import com.cardealer.parser.interfaces.ModelParser;
import com.cardealer.repositories.CarRepository;
import com.cardealer.repositories.PartRepository;
import com.cardealer.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private PartRepository partRepository;

    @Autowired
    private ModelParser modelParser;


    @Override
    public void create(CarImportJSONDto carImportJSONDto) {
        Car car = this.modelParser.convert(carImportJSONDto, Car.class);

        long partsCount = this.partRepository.count();
        for (int i = 0; i < 4; i++) {
            Part part = this.partRepository.findOne(ThreadLocalRandom.current().nextLong(1, partsCount + 1));
            car.addPart(part);
        }
        this.carRepository.save(car);
    }

    @Override
    public List<CarsAndPartsExportJSONDto> findAllCarsAndParts() {
        List<Car> cars = this.carRepository.findAll();

        List<CarsAndPartsExportJSONDto> dtoCars = this.modelParser.convert(cars, CarsAndPartsExportJSONDto.class);
        return dtoCars;
    }

    @Override
    public CarsExportXMLDto findAllCarsAsXML() {
        List<Car> cars = this.carRepository.findAll();

         List<CarExportXMLDto> carExportXMLDtos = this.modelParser.convert(cars, CarExportXMLDto.class);

        CarsExportXMLDto carsExportXMLDto = new CarsExportXMLDto();
        carsExportXMLDto.setCars(new HashSet<>(carExportXMLDtos));
        return carsExportXMLDto;
    }
}