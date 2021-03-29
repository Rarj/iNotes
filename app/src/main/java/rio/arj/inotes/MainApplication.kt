package rio.arj.inotes

import android.app.Application
import android.content.Context

class MainApplication : Application() {

  init {
    instance = this
  }

//  val databaseBuilder = DatabaseBuilder.getInstance(MainApplication.applicationContext())

  companion object {
    private var instance: MainApplication? = null

    fun applicationContext(): Context {
      return instance!!.applicationContext
    }
  }

}