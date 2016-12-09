package com.cardealer.terminal;

import com.cardealer.config.Paths;
import com.cardealer.domain.dtos.json.*;
import com.cardealer.domain.dtos.xml.CarsExportXMLDto;
import com.cardealer.io.interfaces.ConsoleIO;
import com.cardealer.parser.interfaces.FileParser;
import com.cardealer.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * Created on 08/12/2016.
 */
@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private SupplierService supplierService;
    @Autowired
    @Qualifier(value = "JSONParser")
    private FileParser jsonParser;

    @Autowired
    @Qualifier(value = "XMLParser")
    private FileParser xmlParser;

    @Autowired
    private ConsoleIO writer;
    @Autowired
    private PartService partService;
    @Autowired
    private CarService carService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private SaleService saleService;

    @Override
    public void run(String... strings) throws Exception {

//        importSupplierFromJson();
//        importPartsFromJson();
//        importCarsFromJson();
//        importCustomerFromJson();
//        generateSales();
//        exportOrderedCustomers();
//        exportSuppliersNotImporting();
//        exportCarsWithParts();
        exportCarsWithPartsToXML();
    }

    private void importSupplierFromJson() {
            SupplierImportJSONDto[] supplierImportJSONDtos = null;
        try {
            supplierImportJSONDtos = this.jsonParser.read(SupplierImportJSONDto[].class, Paths
                    .SUPPLIERS_JSON_IMPORT);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (SupplierImportJSONDto supplierImportJSONDto : supplierImportJSONDtos) {
            try {
                this.supplierService.create(supplierImportJSONDto);
                writer.write(String.format("Supplier %s imported successfully", supplierImportJSONDto.getName()));
            }catch (Exception e) {
                this.writer.write("Invalid supplier data.");
            }
        }
    }

    private void importPartsFromJson() {
        PartImportJSONDto[] partImportJSONDtos = null;
        try {
            partImportJSONDtos = this.jsonParser.read(PartImportJSONDto[].class, Paths
                    .PARTS_JSON_IMPORT);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (PartImportJSONDto partImportJSONDto : partImportJSONDtos) {
            try {
                this.partService.create(partImportJSONDto);
                writer.write(String.format("Part %s imported successfully", partImportJSONDto.getName()));
            }catch (Exception e) {
                this.writer.write("Invalid part data.");
            }
        }
    }

    private void importCarsFromJson() {
        CarImportJSONDto[] carImportJSONDtos = null;
        try {
            carImportJSONDtos = this.jsonParser.read(CarImportJSONDto[].class, Paths
                    .CARS_JSON_IMPORT);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (CarImportJSONDto carImportJSONDto : carImportJSONDtos) {
            try {
                this.carService.create(carImportJSONDto);
                writer.write(String.format("%s %s imported successfully", carImportJSONDto.getMake(), carImportJSONDto.getModel()));
            }catch (Exception e) {
                this.writer.write("Invalid car data.");
            }
        }
    }


    private void importCustomerFromJson() {
        CustomerImportJSONDto[] customerImportJSONDtos = null;
        try {
            customerImportJSONDtos = this.jsonParser.read(CustomerImportJSONDto[].class, Paths
                    .CUSTOMERS_JSON_IMPORT);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (CustomerImportJSONDto customerImportJSONDto : customerImportJSONDtos) {
            try {
                this.customerService.create(customerImportJSONDto);
                writer.write(String.format("Customer %s imported successfully", customerImportJSONDto.getName()));
            }catch (Exception e) {
                this.writer.write("Invalid customer data.");
            }
        }
    }

    private void generateSales() {
        try {
            this.saleService.generateSales();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void exportOrderedCustomers(){
        List<OrderedCustomersExportJSONDto> exportJSONDtos = this.customerService.findAllOrderByNameAndBirthDate();

        try {
            this.jsonParser.write(exportJSONDtos, Paths.ORDERED_CUSTOMERS_JSON_EXPORT);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void exportSuppliersNotImporting(){
        List<SuppliersNotImportersExportJSONDto> exportJSONDtos = this.supplierService.findByIsImporter(false);

        try {
            this.jsonParser.write(exportJSONDtos, Paths.SUPPLIERS_NOTIMPORTING_JSON_EXPORT);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void exportCarsWithParts(){
        List<CarsAndPartsExportJSONDto> exportJSONDtos = this.carService.findAllCarsAndParts();

        try {
            this.jsonParser.write(exportJSONDtos, Paths.CARS_AND_PARTS_JSON_EXPORT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void exportCarsWithPartsToXML() {
        CarsExportXMLDto carsExportXMLDto = this.carService.findAllCarsAsXML();

        try {
            this.xmlParser.write(carsExportXMLDto, Paths.CARS_AND_PARTS_XML_EXPORT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
