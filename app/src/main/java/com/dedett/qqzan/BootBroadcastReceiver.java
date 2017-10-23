package com.dedett.qqzan;
import android.content.*;


public class BootBroadcastReceiver extends BroadcastReceiver
{
	String action_boot="android.intent.action.BOOT_COMPLETED";

	@Override
	public void onReceive(Context context, Intent intent)
	{
		if (intent.getAction().equals(action_boot)){
		Intent ootStartIntent=new Intent(context, MainActivity.class);
		ootStartIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(ootStartIntent);
		}

	} }
