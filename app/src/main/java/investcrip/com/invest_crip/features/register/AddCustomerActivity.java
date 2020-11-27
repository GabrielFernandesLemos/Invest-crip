package investcrip.com.invest_crip.features.register;

import androidx.appcompat.app.AppCompatActivity;
import investcrip.com.invest_crip.R;
import investcrip.com.invest_crip.features.register.model.Customer;
import investcrip.com.invest_crip.features.register.source.local.CustomerDAO;
import investcrip.com.invest_crip.features.register.source.local.CustomerDAOImpl;
import investcrip.com.invest_crip.features.register.source.local.CustomerLocalDataSource;
import investcrip.com.invest_crip.features.register.source.local.CustomerLocalDataSourceImpl;
import investcrip.com.invest_crip.features.register.source.local.CustomerRepository;
import investcrip.com.invest_crip.features.register.source.local.CustomerRepositoryImpl;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.koin.java.KoinJavaComponent;

import java.util.Calendar;

import javax.sql.DataSource;

public class AddCustomerActivity extends AppCompatActivity {

    TextView txtNameCustomer;
    TextView txtEmailCustomer;
    TextView txtCpfCustomer;
    TextView txtBithdayCustomer;
    TextView txtPhoneNumberCustomer;
    TextView txtBalanceCustomer;

    private CustomerRepository customerRepository = KoinJavaComponent.get(CustomerRepository.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);

        txtNameCustomer = findViewById(R.id.txtNameCustomer);
        txtEmailCustomer = findViewById(R.id.txtEmailCustomer);
        txtCpfCustomer = findViewById(R.id.txtCpfCustomer);
        txtBithdayCustomer = findViewById(R.id.txtBithdayCustomer);
        txtBithdayCustomer.setInputType(InputType.TYPE_NULL);
        txtPhoneNumberCustomer = findViewById(R.id.txtPhoneNumberCustomer);
        txtBalanceCustomer = findViewById(R.id.txtBalanceCustomer);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        FloatingActionButton fabAddCustomer = findViewById(R.id.fabAddCustomer);

        txtBithdayCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(AddCustomerActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        i1 = i1+1;
                        String date = i2+"/"+i1+"/"+i;
                        txtBithdayCustomer.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        fabAddCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateEnteredValues()) {
                    customerRepository.save(getCustomerData());
                    finish();
                }
            }
        });

    }

    public Customer getCustomerData() {
        Customer customer = new Customer();
        customer.setName(txtNameCustomer.getText().toString());
        customer.setEmail(txtEmailCustomer.getText().toString());
        customer.setCpf(txtCpfCustomer.getText().toString());
        customer.setBirthday(txtBithdayCustomer.getText().toString());
        customer.setPhoneNumber(txtPhoneNumberCustomer.getText().toString());
        customer.setBalance(txtBalanceCustomer.getText().toString());

        return customer;
    }

    public boolean validateEnteredValues() {
        if (txtNameCustomer.getText().toString().equals("")
                || txtEmailCustomer.getText().toString().equals("")
                || txtCpfCustomer.getText().toString().equals("")
                || txtBithdayCustomer.getText().toString().equals("")
                || txtPhoneNumberCustomer.getText().toString().equals("")
                || txtBalanceCustomer.getText().toString().equals("")) {
            Toast.makeText(AddCustomerActivity.this, R.string.enteredValues, Toast.LENGTH_LONG).show();
            return false;
        } else {
            return true;
        }
    }
}
