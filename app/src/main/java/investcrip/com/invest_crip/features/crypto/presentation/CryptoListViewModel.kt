package investcrip.com.invest_crip.features.crypto.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import investcrip.com.invest_crip.features.crypto.presentation.entity.Crypto
import investcrip.com.invest_crip.features.crypto.source.remote.CryptoRepository

class CryptoListViewModel(
        private val repository: CryptoRepository
) : ViewModel() {

    val cryptos: LiveData<List<Crypto>> = liveData {
        val data = repository.getAll()
        emit(data)
    }
}