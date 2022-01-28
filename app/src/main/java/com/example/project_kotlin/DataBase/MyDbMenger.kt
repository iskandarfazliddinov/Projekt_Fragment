package com.example.project_kotlin.DataBase

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.provider.ContactsContract
import com.example.project_kotlin.Data.Data
import com.example.project_kotlin.Fragments.Fragment_4

class MyDbMenger(context: Context) {
    val myDbHelper = MyDbHelper(context)
    var db:SQLiteDatabase? = null

    fun openDb(){
        db=myDbHelper.readableDatabase
    }
    fun insertDb(turi: String,haqida:String){
        val values = ContentValues().apply {
            put(MyDbNameClass.MALUMOT_TURI,turi)
            put(MyDbNameClass.MALUMOT_HAQIDA,haqida)
        }
        db?.insert(MyDbNameClass.TABLE_NAME,null,values)
    }
    @SuppressLint("Range")
    fun readData():ArrayList<String>{
        val dataList = ArrayList<String>()

        val cursor = db?.query(
            MyDbNameClass.TABLE_NAME,
            null,
            null,
            null,
            null,
            null,
            null
        )
        with(cursor){
            if (cursor != null)
            while (this?.moveToNext()!!){
                val dataText_one = cursor.getString(cursor.getColumnIndex(MyDbNameClass.MALUMOT_TURI)).toString()
                val dataText_two = cursor.getString(cursor.getColumnIndex(MyDbNameClass.MALUMOT_HAQIDA))

                dataList.add(dataText_one)
            }
        }
        cursor?.close()
        db?.close()
        return dataList
    }


    fun closeDb(){
        myDbHelper.close()
    }
}