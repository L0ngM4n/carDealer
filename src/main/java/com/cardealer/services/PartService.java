package com.cardealer.services;

import com.cardealer.domain.dtos.json.PartImportJSONDto;

public interface PartService {

    void create(PartImportJSONDto partImportJSONDto);
}