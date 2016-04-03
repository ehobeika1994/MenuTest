package org.me.myandroidstuff;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MenuTestActivity extends Activity 
{
	View topView;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        topView = (View)findViewById(R.id.topView);
        registerForContextMenu(topView);
    }
    
    public boolean onCreateOptionsMenu(Menu menu)
    {
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.mainmenu, menu);
    	return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
    	switch (item.getItemId())
    	{
    		case R.id.red:  Toast.makeText(this, "Red Option", Toast.LENGTH_LONG).show();
    						topView.setBackgroundColor(Color.RED);
    						break;
    		case R.id.green:topView.setBackgroundColor(Color.GREEN);
    						break;
    		case R.id.blue: topView.setBackgroundColor(Color.BLUE);
    						break; 
    		case R.id.black: topView.setBackgroundColor(Color.BLACK);
							break;  
    		case R.id.yellow: topView.setBackgroundColor(Color.YELLOW);
			break;  							
    						
    	}
    	
    	return true;
    }
    
    @Override
    public void onCreateContextMenu(ContextMenu menu,View v,ContextMenuInfo menuInfo)
    {
    	super.onCreateContextMenu(menu, v, menuInfo);
    	menu.setHeaderTitle("Colour Context Menu");
    	menu.add(0,v.getId(),0,"Red");
    	menu.add(0,v.getId(),0,"Green");
    	menu.add(0,v.getId(),0,"Blue");
    	menu.add(0,v.getId(),0,"Yellow");
    }
    
    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
    	if (item.getTitle()=="Red")
    	{
    		Toast.makeText(this, "Red Option", Toast.LENGTH_LONG).show();
    		topView.setBackgroundColor(Color.RED);
    	}
    	else if (item.getTitle()=="Green")
    	{
    		topView.setBackgroundColor(Color.GREEN);
    	}
    	else
    		if (item.getTitle()=="Blue")
    		{
    				topView.setBackgroundColor(Color.BLUE);
    		}
    		else
    			if (item.getTitle()=="Yellow")
        		{
        				topView.setBackgroundColor(Color.YELLOW);
        		}
        		else
    			return false;
    	
    	return true;
    }
}