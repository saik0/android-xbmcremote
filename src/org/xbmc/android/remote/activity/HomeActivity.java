/*
 *      Copyright (C) 2005-2009 Team XBMC
 *      http://xbmc.org
 *
 *  This Program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2, or (at your option)
 *  any later version.
 *
 *  This Program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with XBMC Remote; see the file license.  If not, write to
 *  the Free Software Foundation, 675 Mass Ave, Cambridge, MA 02139, USA.
 *  http://www.gnu.org/copyleft/gpl.html
 *
 */

package org.xbmc.android.remote.activity;

import org.xbmc.android.remote.R;
import org.xbmc.android.util.XBMCControl;
import org.xbmc.httpapi.MediaType;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.EditText;

public class HomeActivity extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_portrait);
        
	    final Button GoMusicButton = (Button) findViewById(R.id.GoMusicButton);
	    GoMusicButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
//                Intent myIntent = new Intent(v.getContext(), AlbumGridActivity.class);
                Intent myIntent = new Intent(v.getContext(), MediaListActivity.class);
                myIntent.putExtra("shareType", MediaType.music.toString());
                startActivityForResult(myIntent, 0);
			}
		});
	    
	    final Button GoVideosButton = (Button) findViewById(R.id.GoVideosButton);
	    GoVideosButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), MediaListActivity.class);
                myIntent.putExtra("shareType", MediaType.video.toString());
                startActivityForResult(myIntent, 0);
			}
		});
	    
	    final Button GoPicturesButton = (Button) findViewById(R.id.GoPicturesButton);
	    GoPicturesButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), MediaListActivity.class);
                myIntent.putExtra("shareType", MediaType.pictures.toString());
                startActivityForResult(myIntent, 0);
			}
		});
	    
	    final Button GoRemoteButton = (Button) findViewById(R.id.GoRemoteButton);
	    GoRemoteButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), RemoteActivity.class);
                startActivityForResult(myIntent, 0);
			}
		});
	    
	    final Button GoNowPlayingButton = (Button) findViewById(R.id.GoNowPlayingButton);
	    GoNowPlayingButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), NowPlayingActivity.class);
                startActivityForResult(myIntent, 0);
			}
		});
	}

	@Override
	public void onWindowAttributesChanged(LayoutParams params) {
		if (params.screenOrientation ==  ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
			setContentView(R.layout.main_portrait);
		else if (params.screenOrientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
			setContentView(R.layout.main_landscape);
		
		super.onWindowAttributesChanged(params);
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, 1, 0, "Settings").setIcon(R.drawable.icon_menu_settings);
		menu.add(0, 2, 0, "Exit").setIcon(R.drawable.icon_menu_exit);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case 1:
				startActivity(new Intent(this, SettingsActivity.class));
				return true;
			case 2:
				this.finish();
				return true;
		}
		return false;
	}
}