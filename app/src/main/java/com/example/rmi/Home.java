package com.example.rmi;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;

public class Home extends Activity {
	Button btnAdd,btnUpdate,btndelete,btnPurchase,btnprint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        
        btnAdd=(Button) findViewById(R.id.btnAddfruits);
        btnUpdate=(Button) findViewById(R.id.btnUpdateFruits);
        btndelete=(Button) findViewById(R.id.btndeletefruits);
        btnPurchase=(Button) findViewById(R.id.btnPurchasefruits);
        btnprint=(Button) findViewById(R.id.btnprintreceipt);
        
        
        btnAdd.setOnClickListener(new OnClickListener() {
    		
    		@Override
    		public void onClick(View arg0) {
    			// TODO Auto-generated method stub
    			
    			Intent i = new Intent(Home.this,AddFruit.class);
                  startActivity(i);	
    			
    		}
    	});
        
        btnUpdate.setOnClickListener(new OnClickListener() {
         public void onClick(View arg0) {
 			// TODO Auto-generated method stub
 			Intent i = new Intent(Home.this,UpdateFruit.class);
               startActivity(i);	
 			
 		}
	});
      
        
       

        btnPurchase.setOnClickListener(new OnClickListener() {
        public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i = new Intent(Home.this,PurchaseFruit.class);
              startActivity(i);	
			
		}
	});
        
 btndelete.setOnClickListener(new OnClickListener() {
    		
    		@Override
    		public void onClick(View arg0) {
    			// TODO Auto-generated method stub
    			Intent i = new Intent(Home.this,DeleteFruit.class);
                  startActivity(i);	
    			
    		}
    	});
 btnprint.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i = new Intent(Home.this,Print.class);
           startActivity(i);	
			
		}
	});
//        
        
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.home, menu);
        //return true;
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home, menu);
        return super.onCreateOptionsMenu(menu);
    }
    
}
