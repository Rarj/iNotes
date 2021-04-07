package rio.arj.inotes.database.dao

import androidx.room.Dao
import androidx.room.Query
import rio.arj.inotes.database.entity.CreateNoteEntity

@Dao
interface ListNoteDao {

  @Query("SELECT * FROM notes")
  suspend fun getAllNotes(): List<CreateNoteEntity>

}