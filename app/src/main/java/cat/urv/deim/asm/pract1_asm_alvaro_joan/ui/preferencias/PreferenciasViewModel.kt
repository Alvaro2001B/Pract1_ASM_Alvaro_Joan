package cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.preferencias

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PreferenciasViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Prefèrencies"
    }
    val text: LiveData<String> = _text
}