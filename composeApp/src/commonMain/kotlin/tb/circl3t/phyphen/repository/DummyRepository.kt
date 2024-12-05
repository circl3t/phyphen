package tb.circl3t.phyphen.repository

import tb.circl3t.phyphen.data.DummyLocalDataSource
import tb.circl3t.phyphen.data.DummyRemoteDataSource
import tb.circl3t.phyphen.model.Dummy

class DummyRepository(
    private val localDataSource: DummyLocalDataSource,
    private val remoteDataSource: DummyRemoteDataSource
) {
  fun getDummy(): Dummy {
    return localDataSource.getDummy()
  }
}
