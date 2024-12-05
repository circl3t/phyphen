package tb.circl3t.phyphen.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import tb.circl3t.phyphen.data.DummyLocalDataSource
import tb.circl3t.phyphen.data.DummyRemoteDataSource
import tb.circl3t.phyphen.repository.DummyRepository
import tb.circl3t.phyphen.viewmodel.MainViewModel

val dummyModule = module {
  single { DummyLocalDataSource() }
  single { DummyRemoteDataSource() }
  single { DummyRepository(get(), get()) }
  viewModelOf(::MainViewModel)
}
