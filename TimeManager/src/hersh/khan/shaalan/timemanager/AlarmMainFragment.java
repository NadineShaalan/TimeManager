 package hersh.khan.shaalan.timemanager;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;


public class AlarmMainFragment extends Fragment {

	AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    private TimePicker alarmTimePicker;
    private static AlarmMainFragment inst;
    private TextView alarmTextView;
    private ToggleButton toggle;
    public View view;
   
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    	Log.d("onreat","created");
    	view = inflater.inflate(R.layout.alarm_fragment, container, false);
        alarmTimePicker = (TimePicker) view.findViewById(R.id.alarmTimePicker);
        alarmTextView = (TextView) view.findViewById(R.id.alarmText);
        ToggleButton alarmToggle = (ToggleButton) view.findViewById(R.id.alarmToggle);
        alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
        toggle = (ToggleButton) view.findViewById(R.id.alarmToggle);
        
        toggle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {  //green
            	Log.d("hu", "hello");
            	if (toggle.isChecked()){
                    Log.d("MyActivity", "Alarm On");
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.HOUR_OF_DAY, alarmTimePicker.getCurrentHour());
                    calendar.set(Calendar.MINUTE, alarmTimePicker.getCurrentMinute());
                    Intent myIntent = new Intent(view.getContext(), AlarmReceiver.class);
                    pendingIntent = PendingIntent.getBroadcast(view.getContext(), 0, myIntent, 0);
                    alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
                    Log.d("time", ""+ System.currentTimeMillis());
                } else {
                    alarmManager.cancel(pendingIntent);
                    setAlarmText("");
                    Log.d("MyActivity", "Alarm Off");
                }
            }
        });

        
        return view;
    }
    
    public static AlarmMainFragment instance() {
        return inst;
    }
    
    @Override
    public void onStart() {
        super.onStart();
        Log.d("onstart", "started");
        inst = this;
    }
    
    
     public void onToggleClicked(View view) {
    	 if (toggle.isChecked()){
             Log.d("MyActivity", "Alarm On");
             Calendar calendar = Calendar.getInstance();
             calendar.set(Calendar.HOUR_OF_DAY, alarmTimePicker.getCurrentHour());
             calendar.set(Calendar.MINUTE, alarmTimePicker.getCurrentMinute());
             Intent myIntent = new Intent(view.getContext(), AlarmReceiver.class);
             pendingIntent = PendingIntent.getBroadcast(view.getContext(), 0, myIntent, 0);
             alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
             Log.d("time", ""+ System.currentTimeMillis());
         } else {
             alarmManager.cancel(pendingIntent);
             setAlarmText("");
             Log.d("MyActivity", "Alarm Off");
         }
    }  

    public void setAlarmText(String alarmText) {
        alarmTextView.setText(alarmText);
    }

	
} 
