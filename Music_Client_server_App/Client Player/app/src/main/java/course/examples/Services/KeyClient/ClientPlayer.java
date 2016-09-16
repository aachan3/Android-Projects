package course.examples.Services.KeyClient;

import android.app.Activity ;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import course.examples.Services.KeyCommon.KeyGenerator;

public class ClientPlayer extends Activity {

	protected static final String TAG = "Client player";
	private KeyGenerator mKeyGeneratorService;
	private boolean Bound = false;
	
	@Override
	public void onCreate(Bundle i) {
		super.onCreate(i);

		setContentView(R.layout.main);

		


//listener for play button
		final Button playButton = (Button) findViewById(R.id.play);
		final EditText edit = (EditText) findViewById(R.id.editText);
		playButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				try {
					
					if (Bound){
						Log.i(TAG, "started song");
						String k=edit.getText().toString();
						if(0>=Integer.parseInt(k)||Integer.parseInt(edit.getText().toString())>=5){
							Toast.makeText(ClientPlayer.this, "Enter a value between 0 and 5",
									Toast.LENGTH_LONG).show();
						}
						else {
							mKeyGeneratorService.startsong(Integer.parseInt(edit.getText().toString()));
						}
					}

				} catch (RemoteException e) {

					Log.e(TAG, e.toString());

				}
			}
		});
//Listener for stop method
		final Button stopButton = (Button) findViewById(R.id.stop);
		stopButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				try {

					
					if (Bound)
						mKeyGeneratorService.stopsong(Integer.parseInt(edit.getText().toString()));
					else {
						Log.i(TAG, "Service not bound!");
					}

				} catch (RemoteException e) {

					Log.e(TAG, e.toString());

				}
			}
		});
		//listener for resume method
		final Button ResumeButton = (Button) findViewById(R.id.resume);
		ResumeButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				try {

					
					if (Bound)
						mKeyGeneratorService.resumesong(Integer.parseInt(edit.getText().toString()));
					else {
						Log.i(TAG, "service was not bound!");
					}

				} catch (RemoteException e) {

					Log.e(TAG, e.toString());

				}
			}
		});
		//listener for pause method
		final Button PauseButton = (Button) findViewById(R.id.pause);
		PauseButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				try {

					
					if (Bound)
					{
						
						mKeyGeneratorService.pausesong(Integer.parseInt(edit.getText().toString()));
					}

					else {
						Log.i(TAG, " service was not bound!");
					}

				} catch (RemoteException e) {

					Log.e(TAG, e.toString());

				}
			}
		});
		//listener for transaction method
		final Button TransacButton = (Button) findViewById(R.id.transaction);
		TransacButton.setOnClickListener(new OnClickListener() {
String[] x;
			public void onClick(View v) {

				try {

					
					if (Bound) {
						 x = mKeyGeneratorService.transac();
						for (String y : x)
							Log.i("Aravind result:", y);
					}
					else {
						Log.i(TAG, " service was not bound!");
					}
                    Intent i = new Intent(getApplicationContext(),transactionActivity.class);
					i.putExtra("result",x);
					startActivity(i);
				} catch (RemoteException e) {

					Log.e(TAG, e.toString());

				}
			}
		});

		
	}

	
	@Override
	protected void onResume() {
		super.onResume();

		if (!Bound) {

			boolean b = false;
			Intent i = new Intent(KeyGenerator.class.getName());
			
			ResolveInfo info = getPackageManager().resolveService(i, Context.BIND_AUTO_CREATE);
			i.setComponent(new ComponentName(info.serviceInfo.packageName, info.serviceInfo.name));

			b = bindService(i, this.mConnection, Context.BIND_AUTO_CREATE);
			if (b) {
				Log.i(TAG, "Ugo says bindService() succeeded!");
			} else {
				Log.i(TAG, "Ugo says bindService() failed!");
			}

		}
	}

	// Unbind from KeyGenerator Service
	@Override
	protected void onPause() {


		super.onPause();
	}
	@Override
	protected void onDestroy() {
		if (Bound) {
			super.onDestroy();
			unbindService(this.mConnection);
			Bound=false;
		}
	}

	private final ServiceConnection mConnection = new ServiceConnection() {

		public void onServiceConnected(ComponentName className, IBinder iservice) {

			mKeyGeneratorService = KeyGenerator.Stub.asInterface(iservice);

			Bound = true;

		}

		public void onServiceDisconnected(ComponentName className) {

			mKeyGeneratorService = null;

			Bound = false;

		}
	};


}
