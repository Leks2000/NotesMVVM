package com.example.notesmvvm.utils

import com.example.notesmvvm.database.DatabaseRepository

const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "type_room"
const val TYPE_FIREBASE = "type_firebase"

lateinit var REPOSITORY: DatabaseRepository
lateinit var LOGIN: String
lateinit var PASSWORD: String

object Constants {
    object Keys {
        const val NOTE_DATABASE = "notes_database"
        const val NOTES_TABLE = "notes_table"
        const val ADD_NEW_NOTE = "Add new note"
        const val NOTE_TITLE = "note title"
        const val NOTE_SUBTITLE = "note subtitle"
        const val ADD_NOTE = "add note"
        const val TITLE = "title"
        const val SUBTITLE = "Subtitle"
        const val WWWU = "What will we use?"
        const val ROOB_DATA =  "Room database"
        const val FIRE_DATA = "Firebase database"
        const val ID = "id"
        const val NONE = "none"
        const val UPDATE = "UPDATE"
        const val DELETE = "DELETE"
        const val NAV_BACK = "NAV_BACK"
        const val EDIT_NOTE = "EDIT_NOTE"
        const val EMPTY = ""
        const val UPDATE_NOTE = "update_note"
        const val SIGN_IN = "Sing in"
        const val LOGIN = "Log in"
        const val LOGIN_TEXT = "Login"
        const val PASSWORD_TEXT = "Password"
    }

    object Screens {
        const val START_SCREEN = ("start_screen")
        const val MAIN_SCREEN = ("main_screen")
        const val ADD_SCREEN = ("add_screen")
        const val NOTE_SCREEN = ("note_screen")
    }
}