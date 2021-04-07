package rio.arj.inotes.repository.list

import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import rio.arj.inotes.database.dao.ListNoteDao

@RunWith(AndroidJUnit4::class)
class ListNoteRepositoryImplTest {

  private var listDao: ListNoteDao = mock(ListNoteDao::class.java)

  private lateinit var repo: ListNoteRepositoryImpl

  @Before
  fun setup() {
    repo = ListNoteRepositoryImpl(listDao)
  }

  @Test
  fun make_sure_function_get_all_notes_call_once(): Unit = runBlocking {
    repo.getAllNotes()
    verify(listDao, times(1)).getAllNotes()
  }

}