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

public class HistoriqueExerciceSQL extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "easyFitDB";
    private static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

    public HistoriqueExerciceSQL(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

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
    private static final String KEY_ID_HISTORIQUE = "idHistorique";
    private static final String KEY_ID_EXERCICE = "idExercice";
    private static final String KEY_DATE = "dateSession";
    private static final String KEY_SERIE = "serieDuree";

    private static final String[] COLUMNS = {KEY_ID_HISTORIQUE, KEY_ID_EXERCICE, KEY_DATE, KEY_SERIE};


    public void addSession(HistoriqueExercice toAdd) {
        Log.d("addSession", toAdd.toString());
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID_EXERCICE, toAdd.getIdExercice());
        values.put(KEY_DATE, toAdd.getDateSession().toString());
        values.put(KEY_SERIE, toAdd.getSerieDuree());


        db.insert(TABLE_HISTORIQUE_EXERCICE,
                null,
                values);

        db.close();
    }

    public HistoriqueExercice getSession(int id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =
                db.query(TABLE_HISTORIQUE_EXERCICE,
                        COLUMNS, " idHistorique = ?",
                        new String[]{String.valueOf(id)},
                        null,
                        null,
                        null,
                        null);

        if (cursor != null)
            cursor.moveToFirst();


        HistoriqueExercice build = new HistoriqueExercice(cursor.getInt(0), cursor.getInt(1), null, cursor.getFloat(3));
        try {
            build.setDateSession(DATE_FORMAT.parse(cursor.getString(2)));
        }catch (ParseException e) {
            e.printStackTrace();
        }

        Log.d("getSession(" + id + ")", build.toString());
        return build;
    }

    public List<HistoriqueExercice> getHistorique() {
        List<HistoriqueExercice> historique = new LinkedList<HistoriqueExercice>();
        String query = "SELECT  * FROM " + TABLE_HISTORIQUE_EXERCICE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        HistoriqueExercice build = null;
        if (cursor.moveToFirst()) {
            do {
                build = new HistoriqueExercice(cursor.getInt(0), cursor.getInt(1), null, cursor.getFloat(3));
                try {
                    build.setDateSession(DATE_FORMAT.parse(cursor.getString(2)));
                }catch (ParseException e) {
                    e.printStackTrace();
                }
                historique.add(build);
            } while (cursor.moveToNext());
        }

        Log.d("getHistorique()", historique.toString());

        return historique;
    }

    public void deleteHistorique() {

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete * from " + TABLE_HISTORIQUE_EXERCICE);
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

