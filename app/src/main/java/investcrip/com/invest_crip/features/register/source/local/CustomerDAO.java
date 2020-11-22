package investcrip.com.invest_crip.features.register.source.local;

import java.util.List;

import investcrip.com.invest_crip.features.register.model.Customer;

public interface CustomerDAO {

    boolean save(Customer customer);

    boolean update(Customer customer);

    boolean delete(Customer customer);

    List<Customer> getAll();
}
