package rio.arj.inotes.features.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import rio.arj.inotes.Constants.REQUEST_CODE_CREATE_NEW_NOTES
import rio.arj.inotes.R
import rio.arj.inotes.databinding.ActivityMainBinding
import rio.arj.inotes.features.create.CreateNoteActivity

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

    listener()
  }

  private fun listener() {
    binding.buttonCreateNewNote.setOnClickListener {
      val intent = Intent(this, CreateNoteActivity::class.java)
      startActivityForResult(intent, REQUEST_CODE_CREATE_NEW_NOTES)
    }
  }
}