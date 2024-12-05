package tb.circl3t.phyphen.data

import tb.circl3t.phyphen.model.Dummy

class DummyLocalDataSource {
  fun getDummy(): Dummy {
    return Dummy("Bob")
  }
}
