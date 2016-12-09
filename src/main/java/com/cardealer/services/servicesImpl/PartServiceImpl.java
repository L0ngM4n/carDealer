package com.cardealer.services.servicesImpl;

import com.cardealer.domain.dtos.json.PartImportJSONDto;
import com.cardealer.domain.entities.Part;
import com.cardealer.domain.entities.Supplier;
import com.cardealer.parser.interfaces.ModelParser;
import com.cardealer.repositories.PartRepository;
import com.cardealer.repositories.SupplierRepository;
import com.cardealer.services.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ThreadLocalRandom;

@Service
@Transactional
public class PartServiceImpl implements PartService {

    @Autowired
    private ModelParser modelParser;

    @Autowired
    private PartRepository partRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public void create(PartImportJSONDto partImportJSONDto) {
        long suppliersCount = this.supplierRepository.count();
        long suppID = ThreadLocalRandom.current().nextLong(1, suppliersCount + 1);
        Supplier supplier = this.supplierRepository.getOne(suppID);
        Part part = this.modelParser.convert(partImportJSONDto, Part.class);
        part.setSupplier(supplier);
        this.partRepository.save(part);
    }
}