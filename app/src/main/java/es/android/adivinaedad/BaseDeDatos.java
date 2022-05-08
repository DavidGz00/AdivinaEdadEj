package es.android.adivinaedad;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDeDatos extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="Nombres.db";

    public BaseDeDatos(Context context) { super(context, DATABASE_NAME, null, DATABASE_VERSION); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE edades (Nombre TEXT PRIMARY KEY, edad TEXT)");
        EdadEstimada maria = new EdadEstimada("Maria", 23);
        this.guardar(maria, db);
        EdadEstimada pedro = new EdadEstimada("Pedro", 35);
        this.guardar(pedro, db);
        EdadEstimada luisa = new EdadEstimada("Luisa", 49);
        this.guardar(luisa, db);
        EdadEstimada jacobo = new EdadEstimada("Jacobo", 72);
        this.guardar(jacobo, db);
        EdadEstimada lily = new EdadEstimada("Lily", 19);
        this.guardar(lily, db);
    }

    private void guardar(EdadEstimada edadE, SQLiteDatabase db){
        if(db==null)
            db=getWritableDatabase();
        db.execSQL("INSERT INTO edades (Nombre, edad) VALUES ('"+edadE.getName()+"','"+edadE.getAge()+"')");
    }

    @SuppressLint("Range")
    public int buscarNombreEdad(String nombre){
        int años=0;
        SQLiteDatabase db = this.getWritableDatabase();
        
        Cursor cursor = db.rawQuery("SELECT * FROM edades WHERE Nombre = ?", new String[]{nombre});
        while(cursor.moveToNext()) {
            años=cursor.getInt(cursor.getColumnIndex("edad"));
        }
        return años;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
