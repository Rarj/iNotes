package rio.arj.inotes.features.create

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import rio.arj.inotes.database.dao.CreateNoteDao
import rio.arj.inotes.repository.create.model.CreateNoteModel

@RunWith(MockitoJUnitRunner::class)
class CreateNoteViewModelTest {

  @get:Rule
  val testInstantTaskExecutorRule = InstantTaskExecutorRule()

  @Mock
  lateinit var daoCreateNote: CreateNoteDao

  private lateinit var viewModel: CreateNoteViewModel

  @Mock
  lateinit var observerButtonSave: Observer<Boolean>

  @Before
  fun setup() {
    viewModel = CreateNoteViewModel(daoCreateNote)

    viewModel.isValidToSave.observeForever(observerButtonSave)
  }

  @Test
  fun button_will_triggered_when_title_changed() = runBlocking {
    viewModel.createModel.value = CreateNoteModel("1", "First Note", "Content Notes")
    verify(observerButtonSave, times(1)).onChanged(true)
  }

}