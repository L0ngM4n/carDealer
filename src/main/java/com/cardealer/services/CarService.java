package com.cardealer.services;

import com.cardealer.domain.dtos.json.CarImportJSONDto;
import com.cardealer.domain.dtos.json.CarsAndPartsExportJSONDto;
import com.cardealer.domain.dtos.xml.CarsExportXMLDto;

import java.util.List;

public interface CarService {

    void create(CarImportJSONDto carImportJSONDto);

    List<CarsAndPartsExportJSONDto> findAllCarsAndParts();

    CarsExportXMLDto findAllCarsAsXML();
}