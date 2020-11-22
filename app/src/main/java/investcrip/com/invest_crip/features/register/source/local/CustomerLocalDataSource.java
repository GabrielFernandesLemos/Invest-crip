package investcrip.com.invest_crip.features.register.source.local;

import java.util.List;

import investcrip.com.invest_crip.features.register.model.Customer;

public interface CustomerLocalDataSource {
    boolean save(Customer customer);
    boolean delete(Customer customer);
    List<Customer> getAll();
}
