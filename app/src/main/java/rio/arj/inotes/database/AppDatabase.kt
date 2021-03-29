package rio.arj.inotes.database

import androidx.room.Database
import androidx.room.RoomDatabase
import rio.arj.inotes.database.dao.CreateNoteDao
import rio.arj.inotes.database.entity.CreateNoteEntity

@Database(entities = [CreateNoteEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun insertNote(): CreateNoteDao

}