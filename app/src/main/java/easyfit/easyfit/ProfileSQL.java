package easyfit.easyfit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import easyfit.easyfit.Profile.Profile;

import java.util.LinkedList;
import java.util.List;


public class ProfileSQL extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "easyFitDB";
    public ProfileSQL(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_PROFILE_TABLE = "CREATE TABLE profile ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nom STRING, " +
                "age INTEGER, " +
                "mail TEXT, " +
                "taille FLOAT, " +
                "poids INTEGER, " +
                "programme STRING )";

        db.execSQL(CREATE_PROFILE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS profile");
        this.onCreate(db);
    }

    private static final String TABLE_PROFILE = "profile";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "nom";
    private static final String KEY_AGE = "age";
    private static final String KEY_MAIL = "mail";
    private static final String KEY_TAILLE = "taille";
    private static final String KEY_POIDS = "poids";
    private static final String KEY_PROGRAM = "programme";

    private static final String[] COLUMNS = {KEY_ID, KEY_NAME, KEY_AGE, KEY_MAIL, KEY_TAILLE, KEY_POIDS, KEY_PROGRAM};

    public void addProfile(Profile profile) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_NAME, profile.getName());
        values.put(KEY_AGE, profile.getAge());
        values.put(KEY_MAIL, profile.getMail());
        values.put(KEY_TAILLE, profile.getTaille());
        values.put(KEY_POIDS, profile.getPoids());

        if(profile.getEntrainementProgram())
            values.put(KEY_PROGRAM, profile.getEntrainementName());
        else
            values.put(KEY_PROGRAM, " ");

        db.insert(TABLE_PROFILE,
                null,
                values);

        db.close();
    }

    public Profile getProfile(int id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =
                db.query(TABLE_PROFILE,
                        COLUMNS,
                        " id = ?",
                        new String[]{String.valueOf(id)},
                        null,
                        null,
                        null,
                        null);

        if (cursor != null)
            cursor.moveToFirst();

        Profile profile = new Profile();
        profile.setName(cursor.getString(1));
        profile.setAge(Integer.parseInt(cursor.getString(2)));
        profile.setMail(cursor.getString(3));
        profile.setTaille(Float.parseFloat(cursor.getString(4)));
        profile.setPoids(Integer.parseInt(cursor.getString(5)));
        profile.setEntrainementName(cursor.getString(6));

        return profile;
    }

    public int updateProfile(Profile profile) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, profile.getName());
        values.put(KEY_AGE, profile.getAge());
        values.put(KEY_MAIL, profile.getMail());
        values.put(KEY_TAILLE, profile.getTaille());
        values.put(KEY_POIDS, profile.getPoids());
        if(profile.getEntrainementProgram())
            values.put(KEY_PROGRAM, profile.getEntrainementName());
        else
            values.put(KEY_PROGRAM, " ");

        int i = db.update(TABLE_PROFILE,
                values,
                KEY_ID + " = ?",
                new String[]{String.valueOf(1)});

        db.close();
        return i;
    }
}