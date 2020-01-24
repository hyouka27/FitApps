package com.example.fitapps.Database
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import android.app.Application


//Model widoku dla naszej aktywności - do historii
class ActivityViewModel(application:Application): AndroidViewModel(application){
    private val db:DAOHelp = DAOHelp.invoke(application)
    internal val allActivity : LiveData<List<Action>> = db.getActDao().allAction()

    fun insert(action:Action){
        db.getActDao().insert(action)
    }
}