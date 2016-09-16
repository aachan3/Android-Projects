package course.examples.Services.KeyService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import android.content.ContentValues;
import android.database.Cursor;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import course.examples.Services.KeyCommon.KeyGenerator;

public class AudioServer extends Service {


	public MediaPlayer mplayer;
	public String Previous="";
	public String Previousclip="none";
	
	private final static Set<UUID> mIDs = new HashSet<UUID>();
	private Database mDbHelper;

	@Override
	public void onCreate(){

		mDbHelper = new Database(this);
        clearAll();

	}
//reading database values through a cursor
	private Cursor read() {
		return mDbHelper.getWritableDatabase().query(Database.TABLE_NAME,
				Database.columns, null, new String[] {}, null, null,
				null);
	}

//clear all the database entries
	private void clearAll() {

		mDbHelper.getWritableDatabase().delete(Database.TABLE_NAME, null, null);

	}


	// Implement the Stub for this Object
	private final KeyGenerator.Stub mBinder = new KeyGenerator.Stub() {


	
		// Implementing the remote methods

//Start song method
		public void startsong(int song) {

			String time = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String name = "clip_" + song;

			ContentValues values = new ContentValues();

			values.put(Database.Timestamp, time);
			values.put(Database.Track_ID, "Playing " + name + " from " + Previous + " " + Previousclip);
			Previous = "Playing";
			Previousclip = name;
			mDbHelper.getWritableDatabase().insert(Database.TABLE_NAME, null, values);
			values.clear();
			int ID = getResources().getIdentifier(name, "raw", getPackageName());

			if (mplayer != null) {
				if (mplayer.isPlaying()) {


					mplayer.stop();

				}

			}
			mplayer = MediaPlayer.create(getApplicationContext(), ID);
			mplayer.start();
		}


//Pause song method
		public void pausesong(int song)
		{
			String time1 = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			ContentValues values = new ContentValues();

			String name1 = "clip_" + song;

			values.put(Database.Timestamp, time1);
			values.put(Database.Track_ID, "Pausing "+ name1+ " from "+ Previous+" "+Previousclip);
            Previous="Paused";
			Previousclip=name1;
			mDbHelper.getWritableDatabase().insert(Database.TABLE_NAME, null, values);
			values.clear();
            mplayer.pause();
		}
		//resume song method
		public void resumesong(int song)
		{
			String time2 = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			ContentValues values = new ContentValues();

			String name2 = "clip_" + song;

			values.put(Database.Timestamp, time2);
			values.put(Database.Track_ID, "resuming "+ name2+ " from "+ Previous+" "+Previousclip);
            Previous="Resumed";
			Previousclip=name2;
			mDbHelper.getWritableDatabase().insert(Database.TABLE_NAME, null, values);
			values.clear();
            mplayer.start();
		}
		//stopsong method
		public void stopsong(int song)
		{
			String time3 = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			ContentValues values = new ContentValues();

			String name3 = "clip_" + song;

			values.put(Database.Timestamp, time3);
			values.put(Database.Track_ID, "stopping "+ name3 + " from "+ Previous+" "+Previousclip);
            Previous="stopped";
			Previousclip=name3;
			mDbHelper.getWritableDatabase().insert(Database.TABLE_NAME, null, values);
			values.clear();
            mplayer.stop();
		}

		//method to read all the database values from database and send the string array to client
		public String[] transac()
		{

			int i=0;
			Cursor m = read();
			int num=m.getCount();
			String[] result= new String[num];
			//move to the first record
			m.moveToFirst();
		do//loop until all the database values are covered
			{
			result[i]=m.getString(0)+"|"+m.getString(1);
				i++;
			}	while(m.moveToNext());
			for(String x:result)
			Log.i("Aravind result:", x);
			return result;

		}


	};

	// Return the Stub defined above
	@Override
	public IBinder onBind(Intent intent) {
		return mBinder;
	}
}

