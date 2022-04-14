package cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.historial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PreferenciasViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is fragment Fragment"
    }
    val text: LiveData<String> = _text
}