package rio.arj.inotes.repository.create

import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import rio.arj.inotes.database.dao.CreateNoteDao
import rio.arj.inotes.database.entity.CreateNoteEntity

@RunWith(AndroidJUnit4::class)
class CreateNoteRepositoryImplTest {

  private var daoCreateNote = mock(CreateNoteDao::class.java)

  lateinit var repo: CreateNoteRepositoryImpl

  @Before
  fun setup() {
    repo = CreateNoteRepositoryImpl(daoCreateNote)
  }

  @Test
  fun insert_should_call_once_time() = runBlocking {
    val expect = CreateNoteEntity(1, "NOtes 1", "Content", "date created")
    repo.createNewNotes(expect)
    verify(daoCreateNote, times(1)).insertNote(expect)
  }

}