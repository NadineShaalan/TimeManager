package hersh.khan.shaalan.timemanager;

	import android.support.v4.app.Fragment;
	import android.support.v4.app.FragmentManager;
	import android.support.v4.app.FragmentPagerAdapter;
	 
	public class FragmentPageAdapter extends FragmentPagerAdapter {
	 
	 public FragmentPageAdapter(FragmentManager fm) {
	  super(fm);
	 }
	 
	 @Override
	 public Fragment getItem(int arg0) {
	  //switch case to go through the different tabs
	  switch (arg0){
	  //first tab
	  case 0:
	   return new CountdownFragment();
	  //second tab
	  case 1:
	   return new TimerFragment();
	  //third tab
	  case 2:
	   return new TodoFragment();
	  
	  default:
	   break;
	  }
	  return null;
	 }
	 
	 @Override
	 public int getCount() {
	  //total number of tabs, three tabs
	  return 4;
	 }
	 
	}

