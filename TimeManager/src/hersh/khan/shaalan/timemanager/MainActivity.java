package hersh.khan.shaalan.timemanager;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;


public class MainActivity extends FragmentActivity implements ActionBar.TabListener {

	AlarmMainFragment alarmFragment;
	
	//Variables
	 ActionBar mActionbar;
	 ViewPager mViewPager;
	 FragmentPageAdapter ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //alarmFragment = (AlarmMainFragment) getSupportFragmentManager()
          //      .findFragmentById(R.id.alarmFragment);
        
        mViewPager = (ViewPager) findViewById(R.id.pager);
        ft = new FragmentPageAdapter(getSupportFragmentManager());
         
        mActionbar = getActionBar();
         
        mViewPager.setAdapter(ft);
         
        //add the different tabs to the action bar
        mActionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        mActionbar.addTab(mActionbar.newTab().setText("Countdown").setTabListener(this));
        mActionbar.addTab(mActionbar.newTab().setText("Timer").setTabListener(this));
        mActionbar.addTab(mActionbar.newTab().setText("Todo").setTabListener(this));
        
        //add the listener to the view pager
        //will allow for update when the user swipes to another tab
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
          
         @Override
         public void onPageSelected(int arg0) {
          //go to the next tab
          mActionbar.setSelectedNavigationItem(arg0);
         }
          
         @Override
         public void onPageScrolled(int arg0, float arg1, int arg2) {
         
         }
          
         @Override
         public void onPageScrollStateChanged(int arg0) {
         }
        });
       }
       
       @Override
       public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
         
       }
       
       @Override
       //use this method to update the view pager to show the current tab that is selected
       public void onTabSelected(Tab arg0, FragmentTransaction arg1) {
        mViewPager.setCurrentItem(arg0.getPosition());
         
       }
       
       @Override
       public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
         
       }

   
   
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
