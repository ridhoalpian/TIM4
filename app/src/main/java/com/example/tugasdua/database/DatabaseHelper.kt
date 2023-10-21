//package com.example.tugasdua.database
//
//import android.content.ContentValues
//import android.content.Context
//import android.database.sqlite.SQLiteDatabase
//import android.database.sqlite.SQLiteOpenHelper
//import android.widget.Toast
//import java.sql.SQLException
//
//class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "dbUser", null, 1) {
//    override fun onCreate(db: SQLiteDatabase) {
//        try {
//            val createTableQuery =
//                "CREATE TABLE tbl_user (id INTEGER PRIMARY KEY AUTOINCREMENT, usernameGithub TEXT, email TEXT, username TEXT, password TEXT)"
//            db.execSQL(createTableQuery)
//
//        } catch (e: SQLException) {
//            e.printStackTrace()
//        }
//    }
//
//    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
//        val dropTableQuery = "DROP TABLE IF EXISTS tbl_User"
//        db.execSQL(dropTableQuery)
//        onCreate(db)
//    }
//
//    fun insertdata(
//        usernameGithub: String,
//        email: String,
//        username: String,
//        password: String
//    ): Boolean {
//        val db = this.writableDatabase
//        val cv = ContentValues()
//        cv.put("usernameGithub", usernameGithub)
//        cv.put("email", email)
//        cv.put("username", username)
//        cv.put("password", password)
//        val result = db.insert("tbl_User", null, cv)
//        return result != -1L
//    }
//
//
//    fun checkuserpass(username: String, password: String): Boolean {
//        val db = this.writableDatabase
//        val query = "SELECT * FROM tbl_user WHERE username = ? AND password = ?"
//        val cursor = db.rawQuery(query, arrayOf(username, password))
//        db.rawQuery(query, arrayOf(username, password)).use { cursor ->
//            if (cursor.count <= 0) {
//                return false
//            }
//        }
//
//
//        //val query = "SELECT * FROM tbl_user where username = '$username' AND password = '$password'"
//        //val cursor = db.rawQuery(query, null)
////        if(cursor.count<=0){
////            cursor.close()
////            return false
////        }
//        cursor.close()
//        return true
//    }
//}
