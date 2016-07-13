package com.example.usuario.pppppp;



        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;

/**
 * Creado por Hermosa Programación
 */
public class LyrikDataSource {

    /*
    Variables para manipulación de datos
     */
    private LyrikReaderDbHelper openHelper;
    private SQLiteDatabase database;

    public LyrikDataSource(Context context) {
        /*
        Creando una instancia hacia la base de datos
         */
        openHelper = new LyrikReaderDbHelper(context);
        database = openHelper.getWritableDatabase();
    }

    public Cursor getAllGenres(){
        /*
        Seleccionamos todas las filas de la tabla Genres
         */
        return database.rawQuery(
                "select * from " + DataBaseScript.PROVINCIA_TABLE_NAME, null);
    }


    public Cursor getArtistsByGenre(String genreSelection) {

        /*
        Argumentos del WHERE
         */
        String selectionArgs[] = new String[]{genreSelection};


        String query =
                "select "+DataBaseScript.ArtistColumns.ID_Canton+","+DataBaseScript.ArtistColumns.NAME_CANTON+
                        " from "+DataBaseScript.CANTON_TABLE_NAME +
                        " where "+DataBaseScript.ArtistColumns.CODIGO+
                        "= ?";
        return database.rawQuery(query,selectionArgs);
    }
}
