package cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PatinetsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "SELECCIONA UN PATINET:"
    }
    val text: LiveData<String> = _text
}