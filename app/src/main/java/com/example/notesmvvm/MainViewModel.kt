package com.example.notesmvvm

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notesmvvm.model.Note
import com.example.notesmvvm.utils.TYPE_FIREBASE
import com.example.notesmvvm.utils.TYPE_ROOM

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val readTest: MutableLiveData<List<Note>> by lazy {
        MutableLiveData<List<Note>>()
    }

    val dbtype: MutableLiveData<String> by lazy {
        MutableLiveData<String>(TYPE_ROOM)
    }


    init {
        readTest.value =
            when(dbtype.value){
                TYPE_ROOM -> {
                    listOf<Note>(
                        Note(title = "Note 1", subtitle = "Subtitile for note 1"),
                        Note(title = "Note 2", subtitle = "Subtitile for note 2"),
                        Note(title = "Note 3", subtitle = "Subtitile for note 3"),
                        Note(title = "Note 4", subtitle = "Subtitile for note 4")
                    )
                }
                TYPE_FIREBASE -> listOf()
                else -> listOf()
            }
    }
    fun initDatabase(type: String) {
        dbtype.value = type
        Log.d("checkData", "MainViewModel initDatabase with type: $type")
    }
}

class MainViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(application = application) as T
        }
        throw IllegalArgumentException("Unkown ViewModel Class")
    }
}
