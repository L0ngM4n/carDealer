package com.cardealer.services;

import com.cardealer.domain.dtos.json.CustomerImportJSONDto;
import com.cardealer.domain.dtos.json.OrderedCustomersExportJSONDto;

import java.util.List;

public interface CustomerService {
    void create(CustomerImportJSONDto customerImportJSONDto);
    List<OrderedCustomersExportJSONDto> findAllOrderByNameAndBirthDate();
}