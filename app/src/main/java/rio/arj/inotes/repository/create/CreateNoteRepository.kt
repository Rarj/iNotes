package rio.arj.inotes.repository.create

import rio.arj.inotes.database.entity.CreateNoteEntity

interface CreateNoteRepository {
  suspend fun createNewNotes(model: CreateNoteEntity)
}