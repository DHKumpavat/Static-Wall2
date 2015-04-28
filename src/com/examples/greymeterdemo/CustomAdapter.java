package com.examples.greymeterdemo;

import java.io.File;
import java.util.ArrayList;





import textdrawable.TextDrawable;
import textdrawable.util.ColorGenerator;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.sax.StartElementListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAdapter extends BaseAdapter implements
OnClickListener {
	
	// declare the color generator and drawable builder
    private ColorGenerator mColorGenerator = ColorGenerator.MATERIAL;
    private TextDrawable.IBuilder mDrawableBuilder = TextDrawable.builder().round();	
	
	public Context mContext;
	DatabaseHandler db;
	int positiond;
	int res = 0;
	ImageView imageView;
	
    private final String[] name;
    private final int[] myid;
    private final String[] msg;
    private final String[] comment;
    private final String[] daysago;
    private final String[] likes;
    private final String[] share;
    private final int[] Imageid;
    
      public CustomAdapter(Context c,int[] myid, String[] name, String[] msg,  String[] comment,  String[] daysago,  String[] likes,  String[] share, int[] Imageid) {
          mContext = c;
          db = new DatabaseHandler(this.mContext);
          this.Imageid = Imageid;
          this.myid = myid;
          this.name = name;
          this.msg = msg;
          this.comment = comment;
          this.daysago = daysago;
          this.likes = likes;
          this.share = share;
      }
    @Override
    public int getCount() {
      // TODO Auto-generated method stub
      return 10;
    }
    @Override
    public Object getItem(int position) {
      // TODO Auto-generated method stub
      return null;
    }
    @Override
    public long getItemId(int position) {
      // TODO Auto-generated method stub
      return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      // TODO Auto-generated method stub
      View grid;
      
      positiond = position;
      
      LayoutInflater inflater = (LayoutInflater) mContext
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
          if (convertView == null) {
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.custom_list, null);
            
          } else {
            grid = (View) convertView;
          }
          
          final TextView textViewId = (TextView) grid.findViewById(R.id.txtid);
          TextView textViewName = (TextView) grid.findViewById(R.id.txtName);
          TextView textViewMsg = (TextView) grid.findViewById(R.id.txtMsg);
          TextView textViewComment = (TextView) grid.findViewById(R.id.txtComment);
          TextView textViewDaysAgo = (TextView) grid.findViewById(R.id.txtDaysAgo);
          final TextView textViewLikes = (TextView) grid.findViewById(R.id.txtLike);
          TextView textViewShares = (TextView) grid.findViewById(R.id.txtShare);
          imageView = (ImageView)grid.findViewById(R.id.imgName);
          ImageView imageViewLikes = (ImageView)grid.findViewById(R.id.imgLike);
          ImageView imageViewComment = (ImageView)grid.findViewById(R.id.imgCheckma);
          ImageView imageViewShares = (ImageView)grid.findViewById(R.id.imgike);
          
          textViewId.setText(myid[position]+"");
          textViewName.setText(name[position]);
          textViewMsg.setText(msg[position]);
          textViewComment.setText(comment[position]);
          textViewDaysAgo.setText(daysago[position] + " days ago");
          textViewLikes.setText(likes[position]);
          textViewShares.setText(share[position]);
          
         // imageView.setImageResource(Imageid[position]);
          
          updateCheckedState();
          
          imageViewLikes.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// Your code that you want to execute on this button click

					String like = textViewLikes.getText().toString();
					String gotid = textViewId.getText().toString();
					int doneid = Integer.parseInt(gotid);
					int ilike = Integer.parseInt(like);
					ilike = ilike + 1;
					
					res =	db.updateContact(new Mydata(doneid,ilike+""));
					
					Log.d("idmy", doneid+" " + res);
					
					 if(res == 1){
				        	Toast.makeText(mContext, "Record Updated..", Toast.LENGTH_SHORT).show();
				        	
				        	Intent i = new Intent(mContext, MainActivity.class);
				        	mContext.startActivity(i);
				        
				          }else{
				        	  Toast.makeText(mContext, "try again..", Toast.LENGTH_SHORT).show();
				          }			
					
				}
				
			});
          
         
          
          
      return grid;
    }
    
    
    private void updateCheckedState() {
            TextDrawable drawable = mDrawableBuilder.build(String.valueOf(name[positiond].charAt(0)), mColorGenerator.getColor(name[positiond]));
            imageView.setImageDrawable(drawable);
            
    }
   
    
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
}