package rio.arj.inotes.features.create

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import rio.arj.inotes.database.dao.CreateNoteDao
import rio.arj.inotes.repository.create.CreateNoteRepositoryImpl
import rio.arj.inotes.repository.create.model.CreateNoteModel

class CreateNoteViewModel(private val daoCreateNote: CreateNoteDao) : ViewModel() {

  var createModel = MutableLiveData<CreateNoteModel>()
    private set

  var isValidToSave = Transformations.map(createModel) {
    it.title.isNotEmpty() && it.content.isNotEmpty()
  }

  private val repo = CreateNoteRepositoryImpl(daoCreateNote)

  fun createNewNote() {
    CoroutineScope(GlobalScope.coroutineContext)
      .launch {
//        repo.createNewNotes(createModel.value)
      }
  }

}