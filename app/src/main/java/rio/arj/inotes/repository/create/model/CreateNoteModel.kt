package rio.arj.inotes.repository.create.model

data class CreateNoteModel(
    val id: String,
    val title: String,
    val content: String,
    val dateCreated: String = System.currentTimeMillis().toString()
) {
    fun isTitleMaxLength(): Boolean {
        return title.length >= 50
    }

    fun isContentMaxLength(): Boolean {
        return content.length >= 2500
    }

    fun isValidToSave(): Boolean {
        return !isTitleMaxLength() && !isContentMaxLength()
    }

}