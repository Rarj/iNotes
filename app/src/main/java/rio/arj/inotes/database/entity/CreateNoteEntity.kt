package rio.arj.inotes.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
class CreateNoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val title: String,
    val content: String,
    val dateCreate: String
)