package rio.arj.inotes.repository.list

import rio.arj.inotes.database.dao.ListNoteDao
import rio.arj.inotes.database.entity.CreateNoteEntity

class ListNoteRepositoryImpl(private val listDao: ListNoteDao) : ListNoteRepository {
  override suspend fun getAllNotes(): List<CreateNoteEntity> {
    return listDao.getAllNotes()
  }
}