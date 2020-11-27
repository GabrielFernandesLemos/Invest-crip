package investcrip.com.invest_crip.features.register;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import investcrip.com.invest_crip.R;
import investcrip.com.invest_crip.features.register.model.Customer;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder> {

    private List<Customer> clientList;

    public CustomerAdapter(List<Customer> clientList) {
        this.clientList = clientList;
    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemList = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_register_adapter, parent, false);

        return new CustomerViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {
        Customer client = clientList.get(position);
        holder.clientName.setText(client.getName());
        holder.clientMail.setText(client.getEmail());
        holder.clientCpf.setText(client.getCpf());
        holder.clientBirthday.setText(client.getBirthday());
        holder.clientPhoneNumber.setText(client.getPhoneNumber());
        holder.clientBalance.setText(client.getBalance());

    }

    @Override
    public int getItemCount() {
        return clientList.size();
    }

    public static class CustomerViewHolder extends RecyclerView.ViewHolder {

        TextView clientName;
        TextView clientMail;
        TextView clientCpf;
        TextView clientBirthday;
        TextView clientPhoneNumber;
        TextView clientBalance;

        public CustomerViewHolder(@NonNull View itemView) {
            super(itemView);

            clientName = itemView.findViewById(R.id.txtNameRegister);
            clientMail = itemView.findViewById(R.id.txtEmailRegister);
            clientCpf = itemView.findViewById(R.id.txtCpfRegister);
            clientBirthday = itemView.findViewById(R.id.txtBirthdayRegister);
            clientPhoneNumber = itemView.findViewById(R.id.txtPhoneNumberRegister);
            clientBalance = itemView.findViewById(R.id.txtBalanceRegister);

        }
    }

}
