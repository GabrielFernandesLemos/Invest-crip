package investcrip.com.invest_crip.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import investcrip.com.invest_crip.R;
import investcrip.com.invest_crip.model.Client;

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.MyViewHolder> {

    private List<Client> clientList;

    public ClientAdapter(List<Client> clientList) {
        this.clientList = clientList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemList = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_client_adapter, parent, false);

        return new MyViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Client client = clientList.get(position);
        holder.clientName.setText( "Nome: " + client.getName() );
    }

    @Override
    public int getItemCount() {
        return clientList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView clientName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            clientName = itemView.findViewById(R.id.clientName);
        }
    }

}
