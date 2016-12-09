package com.cardealer.services.servicesImpl;

import com.cardealer.domain.dtos.json.SupplierImportJSONDto;
import com.cardealer.domain.dtos.json.SuppliersNotImportersExportJSONDto;
import com.cardealer.domain.entities.Supplier;
import com.cardealer.parser.interfaces.ModelParser;
import com.cardealer.repositories.SupplierRepository;
import com.cardealer.services.SupplierService;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ModelParser modelParser;

    @Override
    public void create(SupplierImportJSONDto supplierImportJSONDto) {

//        PropertyMap<SupplierImportJSONDto, Supplier> propertyMap = new PropertyMap<SupplierImportJSONDto, Supplier>() {
//            @Override
//            protected void configure() {
//                map(source.isImporter(), destination.isImporter());
//            }
//        };

        Supplier supplier =
                this.modelParser.convert(supplierImportJSONDto, Supplier.class);
        this.supplierRepository.save(supplier);
    }

    @Override
    public List<SuppliersNotImportersExportJSONDto> findByIsImporter(boolean isImporter) {
        List<Supplier> suppliers = this.supplierRepository.findByIsImporter(isImporter);

        PropertyMap<Supplier, SuppliersNotImportersExportJSONDto> propertyMap = new PropertyMap<Supplier, SuppliersNotImportersExportJSONDto>() {

            @Override
            protected void configure() {
                map(source.getParts().size(), destination.getPartsCount());
            }
        };

        List<SuppliersNotImportersExportJSONDto> converted = this.modelParser.convert(suppliers, SuppliersNotImportersExportJSONDto.class, propertyMap);

        return converted;
    }
}