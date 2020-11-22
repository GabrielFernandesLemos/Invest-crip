package investcrip.com.invest_crip.features.crypto.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import org.koin.java.KoinJavaComponent;

import investcrip.com.invest_crip.R;
import kotlin.Lazy;

public class CryptoListFragment extends Fragment {

    private Lazy<CryptoListViewModel> viewModel = KoinJavaComponent.inject(CryptoListViewModel.class);
    private CryptoListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        return inflater.inflate(R.layout.fragment_crypto_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new CryptoListAdapter();
        RecyclerView recyclerView = view.findViewById(R.id.cryptoRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        viewModel.getValue().getCryptos().observe(this, cryptos -> {
            adapter.submitList(cryptos);
        });

    }
}
