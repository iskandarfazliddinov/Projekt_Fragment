package com.example.project_kotlin.DataBase


import android.provider.BaseColumns

object MyDbNameClass {

    const val TABLE_NAME = "my_table"
    const val MALUMOT_TURI = "turi"
    const val MALUMOT_HAQIDA = "haqida"


    const val DATABASE_VERSION = 3
    const val DATABASE_NAME = "table.db"

    const val SQL_CREATE_ENTRIES =
        "CREATE TABLE IF NOT EXISTS $TABLE_NAME ("+
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "$MALUMOT_TURI TEXT," +
                "$MALUMOT_HAQIDA TEXT)"

    const val SQL_DELETE_ENTERIES = "DROP TABLE IF EXISTS $TABLE_NAME"
}