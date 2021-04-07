package rio.arj.inotes.repository.list

import rio.arj.inotes.database.entity.CreateNoteEntity

interface ListNoteRepository {
  suspend fun getAllNotes(): List<CreateNoteEntity>
}