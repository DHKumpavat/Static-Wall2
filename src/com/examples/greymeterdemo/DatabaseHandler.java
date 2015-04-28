package com.examples.greymeterdemo;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
 
public class DatabaseHandler extends SQLiteOpenHelper {
 
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "greymeter";
 
    // Contacts table name
    private static final String TABLE_CONTACTS = "mydata";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_MSG = "msg";
    private static final String KEY_COMMENT = "comment";
    private static final String KEY_DAYSAGO = "daysago";
    private static final String KEY_LIKE = "like";
    private static final String KEY_SHARE = "share";
 

	SQLiteDatabase db;
	
	
    
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }
 
    
    
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "Create Table if not exists " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_MSG + " TEXT," + KEY_COMMENT + " TEXT," +KEY_DAYSAGO + " TEXT," + KEY_LIKE + " TEXT," +
                KEY_SHARE + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
        
       
    }
 

    
    // Upgrading database
    
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
 
        // Create tables again
        onCreate(db);
    }
 
    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */
 
    // Adding new contact
    void addContact(Mydata contact) {
         db = getWritableDatabase();
        
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName()); // Contact Name
        values.put(KEY_MSG, contact.get_msg()); // Contact Phone
        values.put(KEY_COMMENT, contact.getComment()); // Contact Phone
        values.put(KEY_DAYSAGO, contact.get_daysago()); // Contact Phone
        values.put(KEY_LIKE, contact.get_likes()); // Contact Phone
        values.put(KEY_SHARE, contact.get_share()); // Contact Phone
 
        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }
 
    // Updating single contact
    public int updateContact(Mydata contact) {
       
    	 db = getWritableDatabase();
 
        ContentValues values = new ContentValues();
        String did = contact.getID()+"";
        values.put(KEY_LIKE, contact.get_likes());
        
        int r = db.update(TABLE_CONTACTS, values, KEY_ID + "=?",
				new String[] {did});
    	    	
        
        db.close(); // Closing database connection
        
    	return r;
    }
    
   	 
    
    
    
    
 
    // Getting All Contacts
    public List<Mydata> getAllContacts() {
        List<Mydata> contactList = new ArrayList<Mydata>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;
 
         db = getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Mydata contact = new Mydata();
                contact.setID(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.set_msg(cursor.getString(2));
                contact.setComment(cursor.getString(3));
                contact.set_daysago(cursor.getString(4));
                contact.set_likes(cursor.getString(5));
                contact.set_share(cursor.getString(6));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
 
        db.close(); // Closing database connection
        // return contact list
        return contactList;
    }

   
}