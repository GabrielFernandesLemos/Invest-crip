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
                .inflate(R.layout.list_client_adapter, parent, false);

        return new CustomerViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {
        Customer client = clientList.get(position);
        holder.clientName.setText("Nome: " + client.getName());
    }

    @Override
    public int getItemCount() {
        return clientList.size();
    }

    public static class CustomerViewHolder extends RecyclerView.ViewHolder {

        TextView clientName;

        public CustomerViewHolder(@NonNull View itemView) {
            super(itemView);

            clientName = itemView.findViewById(R.id.clientName);
        }
    }

}
