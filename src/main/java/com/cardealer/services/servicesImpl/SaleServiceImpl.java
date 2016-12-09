package com.cardealer.services.servicesImpl;

import com.cardealer.domain.entities.Car;
import com.cardealer.domain.entities.Customer;
import com.cardealer.domain.entities.Sale;
import com.cardealer.repositories.CarRepository;
import com.cardealer.repositories.CustomerRepository;
import com.cardealer.repositories.SaleRepository;
import com.cardealer.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ThreadLocalRandom;

@Service
@Transactional
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CustomerRepository  customerRepository;

    @Override
    public void generateSales() {
        long customerCount = this.customerRepository.count();
        for (int i = 0; i < customerCount; i++) {
            Sale sale = new Sale();
            long carsCount = this.carRepository.count();
            //long customerCount = this.customerRepository.count();
            long carId = ThreadLocalRandom.current().nextLong(1, carsCount);
            long customerId = ThreadLocalRandom.current().nextLong(1, customerCount);
            Customer customer = this.customerRepository.findOne(customerId);
            Car car = this.carRepository.findOne(carId);
            sale.setCar(car);
            sale.setCustomer(customer);
            int discount = ThreadLocalRandom.current().nextInt(0, 7);
            int[] discounts = new int[]{0, 5, 10, 15, 20, 30, 40, 50};
            sale.setDiscount(discounts[discount]);

            this.saleRepository.save(sale);
        }


    }
}