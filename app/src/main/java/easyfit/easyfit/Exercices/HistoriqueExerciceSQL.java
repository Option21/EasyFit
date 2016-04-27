package easyfit.easyfit.Exercices;

import android.database.sqlite.SQLiteOpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import easyfit.easyfit.R;

/**
 * Created by Bomb-X on 23/04/16.
 */

public class HistoriqueExerciceSQL extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "easyFitDB";

    private static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

    public HistoriqueExerciceSQL(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //db.execSQL("DROP TABLE IF EXISTS HistoriqueExercice");

        String CREATE_HISTORIQUE_TABLE = "CREATE TABLE HistoriqueExercice ( " +
                "idHistorique INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "idExercice INTEGER, " +
                "dateSession DATE, " +
                "serieDuree FLOAT )";

        db.execSQL(CREATE_HISTORIQUE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS HistoriqueExercice");
        this.onCreate(db);
    }

    private static final String TABLE_HISTORIQUE_EXERCICE = "HistoriqueExercice";

    // Books Table Columns names
    private static final String KEY_ID_HISTORIQUE = "idHistorique";
    private static final String KEY_ID_EXERCICE = "idExercice";
    private static final String KEY_DATE = "dateSession";
    private static final String KEY_SERIE = "serieDuree";

    private static final String[] COLUMNS = {KEY_ID_HISTORIQUE, KEY_ID_EXERCICE, KEY_DATE, KEY_SERIE};


    public void addSession(HistoriqueExercice toAdd) {
        Log.d("addSession", toAdd.toString());
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_ID_EXERCICE, toAdd.getIdExercice());
        values.put(KEY_DATE, toAdd.getDateSession().toString());
        values.put(KEY_SERIE, toAdd.getSerieDuree());


        // 3. insert
        db.insert(TABLE_HISTORIQUE_EXERCICE, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values

        // 4. close
        db.close();
    }

    public HistoriqueExercice getSession(int id) {

        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor =
                db.query(TABLE_HISTORIQUE_EXERCICE, // a. table
                        COLUMNS, // b. column names
                        " idHistorique = ?", // c. selections
                        new String[]{String.valueOf(id)}, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        // 4. build object

        HistoriqueExercice build = new HistoriqueExercice(cursor.getInt(0), cursor.getInt(1), null, cursor.getFloat(3));
        //  build.setIdHistorique(Integer.parseInt(cursor.getString(0)));
        // build.setIdExercice(Integer.parseInt(cursor.getString(1)));
        try {
            build.setDateSession(DATE_FORMAT.parse(cursor.getString(2)));
        }catch (ParseException e) {
            e.printStackTrace();
        }
        //  build.setSerieDuree(cursor.getFloat(3));


        Log.d("getSession(" + id + ")", build.toString());

        // 5. return book
        return build;
    }

    // Get All Books
    public List<HistoriqueExercice> getHistorique() {

        List<HistoriqueExercice> historique = new LinkedList<HistoriqueExercice>();


        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_HISTORIQUE_EXERCICE;

        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // 3. go over each row, build and add it to list
        HistoriqueExercice build = null;
        if (cursor.moveToFirst()) {
            do {
                build = new HistoriqueExercice(cursor.getInt(0), cursor.getInt(1), null, cursor.getFloat(3));
                //  build.setIdHistorique(Integer.parseInt(cursor.getString(0)));
                // build.setIdExercice(Integer.parseInt(cursor.getString(1)));
                try {
                    build.setDateSession(DATE_FORMAT.parse(cursor.getString(2)));
                }catch (ParseException e) {
                    e.printStackTrace();
                }
                historique.add(build);
            } while (cursor.moveToNext());
        }

        Log.d("getHistorique()", historique.toString());

        // return books
        return historique;
    }

    // Deleting single book
    public void deleteHistorique() {

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        // 2. delete
        db.execSQL("delete * from " + TABLE_HISTORIQUE_EXERCICE);
        // 3. close
        db.close();

        Log.d("deleteHistorique", "historiqueDeleted");
    }

    public static class HistoriqueExercice {

        private int idHistorique;
        private int idExercice;
        private ItemListExercice.Exercices exercice;
        private Date dateSession;
        private float serieDuree;

        public HistoriqueExercice(int idHisto, int idExo, Date date, float serie) {

            ItemListExercice list = new ItemListExercice();

            this.idHistorique = idHisto;
            this.idExercice = idExo;
            this.dateSession = date;
            this.serieDuree = serie;
            this.exercice = list.ITEMS.get(idExo);
        }

        public HistoriqueExercice() {
        }

        ;

        @Override
        public String toString() {
            return "HistoriqueExercice{" +
                    "idHistorique=" + idHistorique +
                    ", idExercice=" + idExercice +
                    ", exercice=" + exercice +
                    ", dateSession=" + dateSession +
                    ", serieDuree=" + serieDuree +
                    '}';
        }

        public int getIdHistorique() {
            return idHistorique;
        }

        public int getIdExercice() {
            return idExercice;
        }

        public ItemListExercice.Exercices getExercice() {
            return exercice;
        }

        public Date getDateSession() {
            return dateSession;
        }

        public float getSerieDuree() {
            return serieDuree;
        }

        public void setIdHistorique(int idHistorique) {
            this.idHistorique = idHistorique;
        }

        public void setIdExercice(int idExercice) {
            this.idExercice = idExercice;
        }

        public void setExercice(ItemListExercice.Exercices exercice) {
            this.exercice = exercice;
        }

        public void setDateSession(Date dateSession) {
            this.dateSession = dateSession;
        }

        public void setSerieDuree(float serieDuree) {
            this.serieDuree = serieDuree;
        }
    }
}

