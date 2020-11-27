package investcrip.com.invest_crip.features.register;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.koin.java.KoinJavaComponent;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Subject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import investcrip.com.invest_crip.R;
import investcrip.com.invest_crip.core.RecyclerItemClickListener;
import investcrip.com.invest_crip.features.MainActivity;
import investcrip.com.invest_crip.features.register.model.Customer;
import investcrip.com.invest_crip.features.register.source.local.CustomerRepository;

public class RegisterFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        return inflater.inflate(R.layout.fragment_customer_register, container, false);
    }

    private List<Customer> customerList = new ArrayList<>();
    private CustomerRepository customerRepository = KoinJavaComponent.get(CustomerRepository.class);
    private RecyclerView recyclerCustomerRegister;
    private Customer CustomerSelected;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FloatingActionButton fab = view.findViewById(R.id.floatingActionButton);

        getAllCustomers();
        recyclerEventClick();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireContext(), AddCustomerActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        getAllCustomers();
    }

    public void getAllCustomers(){

        customerList = customerRepository.getAll();

        CustomerAdapter customerAdapter = new CustomerAdapter( customerList );

        recyclerCustomerRegister = requireView().findViewById(R.id.recyclerCustomerRegister);

        recyclerCustomerRegister = requireView().findViewById(R.id.recyclerCustomerRegister);

        setRecyclerView(customerAdapter);

    }

    public void setRecyclerView(CustomerAdapter customerAdapter){
        recyclerCustomerRegister = requireView().findViewById(R.id.recyclerCustomerRegister);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( requireContext() );
        recyclerCustomerRegister.setLayoutManager( layoutManager );
        recyclerCustomerRegister.setHasFixedSize(true);
        recyclerCustomerRegister.addItemDecoration(new DividerItemDecoration(requireContext(), LinearLayout.VERTICAL));
        recyclerCustomerRegister.setAdapter( customerAdapter  );
    }

    public void recyclerEventClick(){
        recyclerCustomerRegister.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        requireContext(),
                        recyclerCustomerRegister,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                                CustomerSelected = customerList.get( position );

                                AlertDialog.Builder dialog = new AlertDialog.Builder(requireContext());

                                dialog.setTitle(R.string.realyDelete);
                                dialog.setMessage(getString(R.string.deleteCustomerMsg) + CustomerSelected.getName() + " ?" );

                                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        if ( customerRepository.delete(CustomerSelected) ){

                                            getAllCustomers();
                                            Toast.makeText(requireContext(),
                                                    "Sucesso ao excluir cliente!",
                                                    Toast.LENGTH_SHORT).show();

                                        }else {
                                            Toast.makeText(requireContext(),
                                                    "Erro ao excluir cliente!",
                                                    Toast.LENGTH_SHORT).show();
                                        }

                                    }
                                });

                                dialog.setNegativeButton("Não", null );

                                dialog.create();
                                dialog.show();

                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );
    }
}
