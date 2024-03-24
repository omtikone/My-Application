package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "shetakarisakha.db";

    public static final String TABLE_USER="tbluser";
    public static final String COLUMN_USER_ID="uid";
    public  static final String COLUMN_USER_NAME="username";
    public static final String COLUMN_USER_EMAIL="email";
    public static final String COLUMN_USER_PASSWORD="password";
    public  static final String COLUMN_USER_CPASSWORD="cpassword";

    public static final String TABLE_FARMER="tblfarmer";
    public static final String COLUMN_FARMER_ID="fid";
    public  static final String COLUMN_FARMER_NAME="username2";
    public static final String COLUMN_FARMER_EMAIL="email2";
    public static final String COLUMN_FARMER_PASSWORD="password2";
    public  static final String COLUMN_FARMER_CPASSWORD="cpassword2";

    public static final String TABLE_GOVSCHEME="tblgovscheme";
    public static final String COLUMN_SCHEME_ID="sid";
    public  static final String COLUMN_SCHEME_NAME="schemename";
    public static final String COLUMN_SCHEME_AMOUNT="schemenidhi";
    public  static final String COLUMN_SCHEME_DURATION="duration";

    public static final String TABLE_ADDRAWMATERIAL="addrawmaterial";
    public static final String COLUMN_ADDRAWMATERIAL_ID="id";
    public static final String COLUMN_ADDRAWMATERIAL_IMAGE="image";
    public  static final String COLUMN_ADDRAWMATERIAL_RAWMATERIALNAME="rawmaterialname";
    public static final String COLUMN_ADDRAWMATERIAL_PRICE="price";
    public  static final String COLUMN_ADDRAWMATERIAL_QUANTITY="quantity";

    public static final String TABLE_SHOPKEEPER="shopkeeper";
    public static final String COLUMN_SHOPKEEPER_ID="id";
    public static final String COLUMN_SHOPKEEPER_NAME="username";
    public  static final String COLUMN_SHOPKEEPER_EMAIL="email";
    public static final String COLUMN_SHOPKEEPER_PASSWORD="password";
    public  static final String COLUMN_SHOPKEEPER_CPASSWORD="cpassword";

    public static final String TABLE_OrderEntry="OrderEntry";
    public static final String COLUMN_OrderEntry_ID="id";
    public static final String COLUMN_OrderEntry_PRODUCTNAME="productname";
    public  static final String COLUMN_OrderEntry_EMAIL="email";
    public static final String COLUMN_OrderEntry_QUANTITY="quantity";
    public  static final String COLUMN_OrderEntry_PRICE="price";
    public static final String COLUMN_OrderEntry_IMAGE="image";

    public static final String TABLE_addfarmproduct="addfarmproduct";
    public static final String COLUMN_addfarmproduct_ID="id";
    public static final String COLUMN_addfarmproduct_IMAGE="image";
    public  static final String COLUMN_addfarmproduct_RAWMATERIALNAME="rawmaterialname";
    public static final String COLUMN_addfarmproduct_PRICE="price";
    public  static final String COLUMN_addfarmproduct_QUANTITY="quantity";



    public static final String CREATE_TABLE_USER="CREATE TABLE "+TABLE_USER+"("
            +COLUMN_USER_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COLUMN_USER_NAME+" TEXT, "
            +COLUMN_USER_EMAIL+" TEXT, "
            +COLUMN_USER_PASSWORD+" TEXT, "
            +COLUMN_USER_CPASSWORD+" TEXT);";

    public static final String CREATE_TABLE_FARMER="CREATE TABLE "+TABLE_FARMER+"("
            +COLUMN_FARMER_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COLUMN_FARMER_NAME+" TEXT, "
            +COLUMN_FARMER_EMAIL+" TEXT, "
            +COLUMN_FARMER_PASSWORD+" TEXT, "
            +COLUMN_FARMER_CPASSWORD+" TEXT);";

    public static final String CREATE_TABLE_GOVSCHEME="CREATE TABLE "+TABLE_GOVSCHEME+"("
            +COLUMN_SCHEME_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COLUMN_SCHEME_NAME+" TEXT, "
            +COLUMN_SCHEME_AMOUNT+" TEXT, "
            +COLUMN_SCHEME_DURATION+" TEXT);";

    public static final String CREATE_TABLE_ADDRAWMATERIAL="CREATE TABLE "+TABLE_ADDRAWMATERIAL+"("
            +COLUMN_ADDRAWMATERIAL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COLUMN_ADDRAWMATERIAL_IMAGE+" BLOB, "
            +COLUMN_ADDRAWMATERIAL_RAWMATERIALNAME+" TEXT, "
            +COLUMN_ADDRAWMATERIAL_PRICE+" TEXT, "
            +COLUMN_ADDRAWMATERIAL_QUANTITY+" TEXT);";

    public static final String CREATE_TABLE_SHOPKEEPER="CREATE TABLE "+TABLE_SHOPKEEPER+"("
            +COLUMN_SHOPKEEPER_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COLUMN_SHOPKEEPER_NAME+" TEXT, "
            +COLUMN_SHOPKEEPER_EMAIL+" TEXT, "
            +COLUMN_SHOPKEEPER_PASSWORD+" TEXT, "
            +COLUMN_SHOPKEEPER_CPASSWORD+" TEXT);";

    public static final String CREATE_TABLE_OrderEntry="CREATE TABLE "+TABLE_OrderEntry+"("
            +COLUMN_OrderEntry_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COLUMN_OrderEntry_PRODUCTNAME+" TEXT, "
            +COLUMN_OrderEntry_EMAIL+" TEXT, "
            +COLUMN_OrderEntry_QUANTITY+" TEXT, "
            +COLUMN_OrderEntry_PRICE+" TEXT,"
            +COLUMN_OrderEntry_IMAGE+" BLOB);";


    public static final String CREATE_TABLE_addfarmproduct="CREATE TABLE "+TABLE_addfarmproduct+"("
            +COLUMN_addfarmproduct_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COLUMN_addfarmproduct_IMAGE+" BLOB, "
            +COLUMN_addfarmproduct_RAWMATERIALNAME+" TEXT, "
            +COLUMN_addfarmproduct_PRICE+" TEXT, "
            +COLUMN_addfarmproduct_QUANTITY+" TEXT);";

    private ByteArrayOutputStream byteArrayOutputStream;
    public static final int DATABASE_VERSION=1;
    private byte[] imageInBytes;
    private Object Context;
    Context context;
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_GOVSCHEME);
        db.execSQL(CREATE_TABLE_FARMER);
        db.execSQL(CREATE_TABLE_OrderEntry);
        db.execSQL(CREATE_TABLE_addfarmproduct);
        db.execSQL(CREATE_TABLE_ADDRAWMATERIAL);
        db.execSQL(CREATE_TABLE_SHOPKEEPER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GOVSCHEME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FARMER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ADDRAWMATERIAL);
       /* db.execSQL("DROP TABLE IF EXISTS addrawmaterial");*/
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SHOPKEEPER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_OrderEntry);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_addfarmproduct);

        onCreate(db);
    }

    public void storeImage(AddRawMaterialDetails addRawMaterialDetails){
        try {
            SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
            Bitmap imageToStoreBitmap=addRawMaterialDetails.getImage();

            byteArrayOutputStream= new ByteArrayOutputStream();
            imageToStoreBitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);

            imageInBytes=byteArrayOutputStream.toByteArray();
            ContentValues values=new ContentValues();

            values.put("image",imageInBytes);
            values.put("rawmaterialname",addRawMaterialDetails.getRawmaterialname());
            values.put("price",addRawMaterialDetails.getPrice());
            values.put("quantity",addRawMaterialDetails.getQuantity());

            long checkIfQueryRuns=sqLiteDatabase.insert("addrawmaterial",null,values);
            if(checkIfQueryRuns!=0){
                Toast.makeText(context, "Raw material added successfully", Toast.LENGTH_SHORT).show();
                sqLiteDatabase.close();
            }
            else {
                Toast.makeText(context, "Failed..Pls Try Again", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e)
        {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public ArrayList<AddRawMaterialDetails> getALLImagesData()
    {
        try{
            SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
            ArrayList<AddRawMaterialDetails> addRawMaterialDetailsArrayList=new ArrayList<>();

            Cursor cursor=sqLiteDatabase.rawQuery("select * from addrawmaterial",null);
             if(cursor.getCount()!=0){
                while (cursor.moveToNext()){
                  byte[] imageBytes=cursor.getBlob(1);
                  String rawmaterialname=cursor.getString(2);
                  String price=cursor.getString(3);
                  String quantity=cursor.getString(4);

                  Bitmap bitmap= BitmapFactory.decodeByteArray(imageBytes,0,imageBytes.length);
                  addRawMaterialDetailsArrayList.add(new AddRawMaterialDetails(rawmaterialname,price,quantity,bitmap));
                }
             return addRawMaterialDetailsArrayList;
             }else
              {
                Toast.makeText(context, "No values exist in database", Toast.LENGTH_SHORT).show();
                return null;
              }
        }catch (Exception e)
         {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
            return null;
        }
    }

    public ArrayList<AddRawMaterialDetails> getsingleProductImagesData()
    {
        try{
            SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
            ArrayList<AddRawMaterialDetails> addRawMaterialDetailsArrayList=new ArrayList<>();

            Cursor cursor=sqLiteDatabase.rawQuery("select * from addrawmaterial where rawmaterialname = ?",null);
            if(cursor.getCount()!=0){
                while (cursor.moveToNext()){
                    byte[] imageBytes=cursor.getBlob(1);
                    String rawmaterialname=cursor.getString(2);
                    String price=cursor.getString(3);
                    String quantity=cursor.getString(4);

                    Bitmap bitmap= BitmapFactory.decodeByteArray(imageBytes,0,imageBytes.length);
                    addRawMaterialDetailsArrayList.add(new AddRawMaterialDetails(rawmaterialname,price,quantity,bitmap));
                }
                return addRawMaterialDetailsArrayList;
            }else
            {
                Toast.makeText(context, "No values exist in database", Toast.LENGTH_SHORT).show();
                return null;
            }
        }catch (Exception e)
        {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
            return null;
        }
    }

    public Boolean insertData(String username, String email, String password,String cpassword){

        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("cpassword", cpassword);

        long result = MyDB.insert("tbluser", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from tbluser where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from tbluser where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean insertShopkeeper(String username, String email, String password, String cpassword){

        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("cpassword", cpassword);

        long result = MyDB.insert("shopkeeper", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean checkshopkeepername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from shopkeeper where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkshopkeepernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from shopkeeper where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }


    public Boolean insertScheme(String schemename, String schemenidhi, String duration) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("schemename", schemename);
        contentValues.put("schemenidhi", schemenidhi);
        contentValues.put("duration", duration);
        long result = MyDB.insert("tblgovscheme", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

   /* public boolean inserDetails(Bitmap image,String rawmaterialname,String price ,String quantity){
        SQLiteDatabase db=getReadableDatabase();
        ByteArrayOutputStream objectByteOutputStream = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG,100,objectByteOutputStream);
        imageInBytes=objectByteOutputStream.toByteArray();
        ContentValues values=new ContentValues();
        values.put("image",imageInBytes);
        values.put("rawmaterialname",rawmaterialname);
        values.put("price",price);
        values.put("quantity",quantity);
        long id=db.insert("addrawmaterial",null,values);
        if(id<=0)
        {
            return false;
        }
        else {
            return true;
        }

    }

*/
    public ArrayList<SchemeDetails> readScheme() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_GOVSCHEME, null);

        // on below line we are creating a new array list.
        ArrayList<SchemeDetails> courseModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(new SchemeDetails(cursorCourses.getString(1),
                        cursorCourses.getString(2),
                        cursorCourses.getString(3)));
            } while (cursorCourses.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorCourses.close();
        return courseModalArrayList;
    }

    public void storeImageFarmProduct(AddRawMaterialDetails addRawMaterialDetails){
        try {
            SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
            Bitmap imageToStoreBitmap=addRawMaterialDetails.getImage();

            byteArrayOutputStream= new ByteArrayOutputStream();
            imageToStoreBitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);

            imageInBytes=byteArrayOutputStream.toByteArray();
            ContentValues values=new ContentValues();

            values.put("image",imageInBytes);
            values.put("rawmaterialname",addRawMaterialDetails.getRawmaterialname());
            values.put("price",addRawMaterialDetails.getPrice());
            values.put("quantity",addRawMaterialDetails.getQuantity());

            long checkIfQueryRuns=sqLiteDatabase.insert("addfarmproduct",null,values);
            if(checkIfQueryRuns!=0){
                Toast.makeText(context, "Added successfully", Toast.LENGTH_SHORT).show();
                sqLiteDatabase.close();
            }
            else {
                Toast.makeText(context, "Failed..Pls Try Again", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e)
        {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    public ArrayList<AddRawMaterialDetails> getALLFARMPRODUCTImagesData()
    {
        try{
            SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
            ArrayList<AddRawMaterialDetails> addRawMaterialDetailsArrayList=new ArrayList<>();

            Cursor cursor=sqLiteDatabase.rawQuery("select * from addfarmproduct",null);
            if(cursor.getCount()!=0){
                while (cursor.moveToNext()){
                    byte[] imageBytes=cursor.getBlob(1);
                    String rawmaterialname=cursor.getString(2);
                    String price=cursor.getString(3);
                    String quantity=cursor.getString(4);

                    Bitmap bitmap= BitmapFactory.decodeByteArray(imageBytes,0,imageBytes.length);
                    addRawMaterialDetailsArrayList.add(new AddRawMaterialDetails(rawmaterialname,price,quantity,bitmap));
                }
                return addRawMaterialDetailsArrayList;
            }else
            {
                Toast.makeText(context, "No values exist in database", Toast.LENGTH_SHORT).show();
                return null;
            }
        }catch (Exception e)
        {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
            return null;
        }
    }
/*

    public Boolean insertFarmerData(String username2, String email2, String password2,String cpassword2){

        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username2", username2);
        contentValues.put("email2", email2);
        contentValues.put("password2", password2);
        contentValues.put("cpassword2", cpassword2);

        long result = MyDB.insert("tblfarmer", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }
    public Boolean checkusernamefarmer(String username2) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from tblfarmer where username2 = ?", new String[]{username2});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
*/


  /*  public Boolean checkusernamepasswordfarmer(String username2, String password2) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from tblfarmer where username2 = ? and password2 = ?", new String[] {username2,password2});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
*/

   /* public Boolean insertSchemeApply(String schemename, String schemetype, String eligibility, String duration) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("schemename", schemename);
        contentValues.put("schemetype", schemetype);
        contentValues.put("eligibility", eligibility);
        contentValues.put("duration", duration);
        long result = MyDB.insert("tblschemeview", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }*/


    public void addtocartData(String productname, String email, String quantity, String price, byte[] image) {

        SQLiteDatabase MyDB = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("productname", productname);
        contentValues.put("email", email);
        contentValues.put("quantity", quantity);
        contentValues.put("price", price);
        contentValues.put("image", image);

        long result = MyDB.insert("OrderEntry", null, contentValues);
    }






}
