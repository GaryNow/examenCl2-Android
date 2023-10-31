package pe.com.examencl2.ProyectoSqLite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BDHelper(context: Context, factory: SQLiteDatabase.CursorFactory?): SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    companion object {
        private val DATABASE_NAME = "BD_CL2"
        private val DATABASE_VERSION = 1
        private val TABLA_AUTORES = "AUTOR"
        private val COLUMN_ID = "IDAUTOR"
        private val COLUMN_AUTOR = "AUTOR"
        private val COLUMN_LIBRO = "LIBRO"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        var queryCreateTable =
            ("CREATE TABLE " + TABLA_AUTORES + " ( " +
                    COLUMN_ID + " INT PRIMARY KEY," +
                    COLUMN_AUTOR + " TEXT, " +
                    COLUMN_LIBRO + " TEXT " + " ) "
                    )

        db?.execSQL(queryCreateTable)
    }

    fun CrearRegistro(autor: String, libro: String){
        val values = ContentValues();
        values.put(COLUMN_AUTOR, autor)
        values.put(COLUMN_LIBRO, libro)
        val db = this.writableDatabase
        db.insert(TABLA_AUTORES, null, values)
        db.close();
    }

    fun ListarTodosRegistros(): ArrayList<ItemsViewModel> {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM " + TABLA_AUTORES, null)
        val data = ArrayList<ItemsViewModel>()
        if (cursor.moveToFirst()) {
            do {
                val autor = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_AUTOR))
                val libro = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_LIBRO))
                data.add(ItemsViewModel(autor, libro))
            } while (cursor.moveToNext())
        }
        cursor.close()

        return data;
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }


}