package com.examples.greymeterdemo;

public class Mydata {
	 
    //private variables
    int _id;
    String _name;
    String _msg;
    String _comment;
    String _daysago;

	String _likes;
    String _share;
 
        // Empty constructor
    public Mydata(){
 
    }
    // constructor
    public Mydata(int id, String name, String msg, String daysago, String likes, String comment, String share){
        this._id = id;
        this._name = name;
        this._msg = msg;
        this._comment = comment;
        this._daysago = daysago;
        this._likes = likes;
        this._share = share;
    }
 
    // constructor
    public Mydata(String name, String msg, String daysago, String likes, String comment, String share){
        this._name = name;
        this._msg = msg;
        this._comment = comment;
        this._daysago = daysago;
        this._likes = likes;
        this._share = share;
    }
    
 // constructor
    public Mydata(int id, String likes){
    	this._id = id;
    	this._likes = likes;
        
    }
    
    // getting ID
    public int getID(){
        return this._id;
    }
 
    // setting id
    public void setID(int id){
        this._id = id;
    }
 
    // getting name
    public String getName(){
        return this._name;
    }
 
    // setting name
    public void setName(String name){
        this._name = name;
    }
 
    // getting phone number
    public String getComment(){
        return this._comment;
    }
 
    // setting phone number
    public void setComment(String comment){
        this._comment = comment;
    }
    
    public String get_msg() {
		return _msg;
	}
	public void set_msg(String _msg) {
		this._msg = _msg;
	}
	public String get_daysago() {
		return _daysago;
	}
	public void set_daysago(String _daysago) {
		this._daysago = _daysago;
	}
	public String get_likes() {
		return _likes;
	}
	public void set_likes(String _likes) {
		this._likes = _likes;
	}
	public String get_share() {
		return _share;
	}
	public void set_share(String _share) {
		this._share = _share;
	}

}