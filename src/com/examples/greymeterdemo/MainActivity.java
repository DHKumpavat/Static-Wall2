package com.examples.greymeterdemo;

import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends Activity {

	ListView lvDisplay;
	DatabaseHandler db;
	CustomAdapter custAdpt ;
	int[] imageId = {
			  R.drawable.a2,R.drawable.s2,R.drawable.s2,
			  R.drawable.d2,R.drawable.d2,R.drawable.k2,
			  R.drawable.s2,R.drawable.a2,R.drawable.t3,
			  R.drawable.y3 };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lvDisplay = (ListView) findViewById(R.id.lvDisplay);
		 db = new DatabaseHandler(this);
		 
		
			// Inserting Contacts
	        Log.d("Insert: ", "Inserting ..");
	        	db.addContact(new Mydata("Aarti", "When you are courting a nice girl an hour seems like a second.", "35", "2", "55", "20"));
	            db.addContact(new Mydata("Shefali", "It is better to lead from behind and to put others in front, especially when you celebrate victory when nice things occur.", "30", "3", "65", "23"));
	            db.addContact(new Mydata("Shivani", "The main thing that you have to remember on this journey is, just be nice to everyone and always smile.", "45", "5", "75", "28"));
	            db.addContact(new Mydata("Dwipal", "It is nice finding that place where you can just go and relax.", "38", "7", "45", "26"));
	            db.addContact(new Mydata("Deepika", "Let's face it, a nice creamy chocolate cake does a lot for a lot of people; it does for me.", "30", "5", "51", "39"));
	            db.addContact(new Mydata("Komal", "We try to be real nice and friendly to people, but sometimes they take advantage of that.", "23", "6", "59", "23"));
	            db.addContact(new Mydata("Sonam", "Progress is a nice word. But change is its motivator. And change has its enemies.", "15", "6", "15", "10"));
	            db.addContact(new Mydata("Avani", "I think it's important to always keep professional and surround yourself with good people, work hard, and be nice to everyone.", "25", "12", "25", "20"));
	            db.addContact(new Mydata("Tamanna", "There is no royal road to anything. One thing at a time, all things in succession. That which grows fast, withers as rapidly. That which grows slowly, endures.", "33", "3", "35", "30"));
	            db.addContact(new Mydata("Yami", "When I stand before God at the end of my life, I would hope that I would not have a single bit of talent left and could say, I used everything you gave me.", "45", "4", "45", "40"));
	     
	  
        // Reading all contacts
        Log.d("Reading: ", "Reading all data..");
        
        
        
        List<Mydata> demodatas = db.getAllContacts();       
        
        int my = demodatas.size();
        
        int[] myid = new int[my];
        String[] name = new String[my];
    	String[] msg = new String[my];
    	String[] comment = new String[my];
    	String[] daysago = new String[my];
    	String[] likes = new String[my];
    	String[] share = new String[my];
    	
        int i = 0;
        
        if(i<=my)
        {
        for (Mydata cn : demodatas) {
         //   String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Comment: " + cn.getComment();
        	myid[i] = cn.getID();
           name[i] = cn.getName();
           msg[i] = cn.get_msg();
           comment[i] = cn.getComment();
           daysago[i] = cn.get_daysago();
           likes[i] = cn.get_likes();
           share[i] = cn.get_share();
           
        custAdpt = new CustomAdapter(this, myid, name, msg, comment, daysago, likes, share, imageId);
        i++;
        }
        }
        
        lvDisplay.setAdapter(custAdpt);
        //db.close();
	}

	
	public void onBackPressed(){
		Intent intent = new Intent(Intent.ACTION_MAIN);
		   intent.addCategory(Intent.CATEGORY_HOME);
		   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		   startActivity(intent);
	}
}
