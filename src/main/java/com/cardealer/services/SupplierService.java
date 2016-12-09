package com.cardealer.services;

import com.cardealer.domain.dtos.json.SupplierImportJSONDto;
import com.cardealer.domain.dtos.json.SuppliersNotImportersExportJSONDto;

import java.util.List;

public interface SupplierService {
    void create(SupplierImportJSONDto supplierImportJSONDto);

    List<SuppliersNotImportersExportJSONDto> findByIsImporter(boolean isImporter);
}