package tb.circl3t.phyphen.data

import tb.circl3t.phyphen.model.Dummy

class DummyRemoteDataSource {
  fun getDummy(): Dummy {
    return Dummy("Charlie")
  }
}
