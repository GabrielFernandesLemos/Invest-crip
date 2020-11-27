package investcrip.com.invest_crip.features.register.source.local;

import java.util.List;

import investcrip.com.invest_crip.features.register.model.Customer;

public class CustomerRepositoryImpl implements CustomerRepository {

    private CustomerLocalDataSource dataSource;

    public CustomerRepositoryImpl(CustomerLocalDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public boolean save(Customer customer) {
        return dataSource.save(customer);
    }

    @Override
    public boolean delete(Customer customer) {
        return dataSource.delete(customer);
    }

    @Override
    public List<Customer> getAll() {
        return dataSource.getAll();
    }
}
