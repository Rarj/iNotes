package rio.arj.inotes.features.create

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import rio.arj.inotes.database.dao.CreateNoteDao

@RunWith(MockitoJUnitRunner::class)
class CreateNoteViewModelTest {

  @get:Rule
  val testInstantTaskExecutorRule = InstantTaskExecutorRule()

  @Mock
  lateinit var daoCreateNote: CreateNoteDao

  lateinit var viewModel: CreateNoteViewModel

  @Mock
  lateinit var observerButtonSave: Observer<Boolean>

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)
    viewModel = CreateNoteViewModel(daoCreateNote)

  }

  @Test
  fun button_will_triggered_when_title_changed() = runBlocking {
    viewModel.isValidToSave.observeForever(observerButtonSave)

    `when`(viewModel.createModel.value).thenReturn(any())

    verify(observerButtonSave).onChanged(true)
  }

}