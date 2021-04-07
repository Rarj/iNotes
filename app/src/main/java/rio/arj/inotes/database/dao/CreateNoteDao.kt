package rio.arj.inotes.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import rio.arj.inotes.database.entity.CreateNoteEntity

@Dao
interface CreateNoteDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertNote(model: CreateNoteEntity)

}