package rio.arj.inotes.repository.create

import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import rio.arj.inotes.database.dao.CreateNoteDao
import rio.arj.inotes.database.dao.ListNoteDao
import rio.arj.inotes.database.entity.CreateNoteEntity
import rio.arj.inotes.repository.list.ListNoteRepositoryImpl

@RunWith(AndroidJUnit4::class)
class CreateNoteRepositoryImplTest {

  private val daoCreateNoteMock = mock(CreateNoteDao::class.java)
  private val daoListNoteMock = mock(ListNoteDao::class.java)

  private lateinit var repo: CreateNoteRepositoryImpl
  private lateinit var repoList: ListNoteRepositoryImpl

  @Before
  fun setup() {
    repo = CreateNoteRepositoryImpl(daoCreateNoteMock)
    repoList = ListNoteRepositoryImpl(daoListNoteMock)
  }

  @Test
  fun insert_should_call_once_time() = runBlocking {
    val expect = CreateNoteEntity(
      title = "Diary",
      content = "Content",
      dateCreate = System.currentTimeMillis().toString()
    )

    repo.createNewNotes(expect)

    verify(daoCreateNoteMock, times(1)).insertNote(expect)
  }

  @Test
  fun list_should_return_inserted_note() = runBlocking {
    val expect = CreateNoteEntity(
      title = "Diary",
      content = "Content",
      dateCreate = System.currentTimeMillis().toString()
    )

    repo.createNewNotes(expect)
    verify(daoCreateNoteMock, times(1)).insertNote(expect)

    `when`(repoList.getAllNotes()).thenReturn(listOf(expect))

    val isContainExpectNote = daoListNoteMock.getAllNotes().contains(expect)
    assertTrue(isContainExpectNote)
  }

}