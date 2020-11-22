package investcrip.com.invest_crip.features.register.source.local;

import java.util.List;

import investcrip.com.invest_crip.features.register.model.Customer;

public class CustomerLocalDataSourceImpl implements CustomerLocalDataSource {

    private CustomerDAO customerDAO;

    public CustomerLocalDataSourceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public boolean save(Customer customer) {
        return customerDAO.save(customer);
    }

    @Override
    public boolean delete(Customer customer) {
        return customerDAO.delete(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerDAO.getAll();
    }
}
