package course.examples.Services.KeyService;

/**
 * Created by aravindachanta on 4/8/16.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
//class for implementing database
public class Database extends SQLiteOpenHelper {

    final static String TABLE_NAME = "Tracklist";
    final static String Timestamp = "timestamp";
    final static String Track_ID = "track_id";
    final static String[] columns = { Timestamp, Track_ID };
//create a table command
    final private static String CREATE_CMD =

            "CREATE TABLE Tracklist ( " + Track_ID
                    + " TEXT PRIMARY KEY, "
                    + Timestamp + " TEXT NOT NULL)";

    final private static String NAME = "track_db";
    final private static Integer VERSION = 1;
    final private Context mContext;

    public Database(Context context) {
        super(context, NAME, null, VERSION);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CMD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // N/A
    }

    void deleteDatabase() {
        mContext.deleteDatabase(NAME);
    }
}
