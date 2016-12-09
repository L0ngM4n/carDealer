package com.cardealer.services.servicesImpl;

import com.cardealer.domain.dtos.json.CustomerImportJSONDto;
import com.cardealer.domain.dtos.json.OrderedCustomersExportJSONDto;
import com.cardealer.domain.entities.Customer;
import com.cardealer.parser.interfaces.ModelParser;
import com.cardealer.repositories.CustomerRepository;
import com.cardealer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelParser modelParser;

    @Override
    public void create(CustomerImportJSONDto customerImportJSONDto) {
        Customer customer = this.modelParser.convert(customerImportJSONDto, Customer.class);
        this.customerRepository.save(customer);
    }

    @Override
    public List<OrderedCustomersExportJSONDto> findAllOrderByNameAndBirthDate() {

        List<Customer> customers = this.customerRepository.findAllOrderByNameASCBirthDateASC();
        List<OrderedCustomersExportJSONDto> converted = this.modelParser.convert(customers, OrderedCustomersExportJSONDto.class);

        return converted;
    }
}