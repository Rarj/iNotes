package rio.arj.inotes.repository.create

import rio.arj.inotes.database.dao.CreateNoteDao
import rio.arj.inotes.database.entity.CreateNoteEntity

class CreateNoteRepositoryImpl(private val daoCreateNote: CreateNoteDao) : CreateNoteRepository {

  override suspend fun createNewNotes(model: CreateNoteEntity) {
    daoCreateNote.insertNote(model)
  }
}