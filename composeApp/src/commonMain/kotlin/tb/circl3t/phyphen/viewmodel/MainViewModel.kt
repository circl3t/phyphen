package tb.circl3t.phyphen.viewmodel

import androidx.lifecycle.ViewModel
import tb.circl3t.phyphen.model.Dummy
import tb.circl3t.phyphen.repository.DummyRepository

class MainViewModel(private val dummyRepository: DummyRepository) : ViewModel() {
  fun getDummy(): Dummy {
    return dummyRepository.getDummy()
  }
}
