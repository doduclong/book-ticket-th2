package com.example.th2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.th2.adapter.ViewPagerAdapter;
import com.example.th2.dal.SQLiteHelper;
import com.example.th2.model.Ticket;

public class UpdateDeleteAcitvity extends AppCompatActivity implements View.OnClickListener {

    public Spinner sp;
    private EditText eName, eDeparture, eTime, eLuggage, eService;
    private Button btUpdate, btCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete_acitvity);
        initView();
        btCancel.setOnClickListener(this);
        btUpdate.setOnClickListener(this);
    }

    private void initView(){
        //sp= findViewById(R.id.spService);
//        eName= findViewById(R.id.spService);
//        eDeparture= findViewById(R.id.spService);
//        eTime= findViewById(R.id.spService);
//        eLuggage= findViewById(R.id.spService);
//        eService= findViewById(R.id.spService);
//        btUpdate= findViewById(R.id.spService);
//        btCancel= findViewById(R.id.spService);
        sp.setAdapter(new ArrayAdapter<String>(this, R.layout.item_spinner, getResources().getStringArray(R.array.category)));


    }

    @Override
    public void onClick(View view) {
        if(view == btCancel){
            finish();
        }
        if(view == btUpdate){
            String t = eName.getText().toString();
            String p = eName.getText().toString();
            String a = eName.getText().toString();
            String b = eName.getText().toString();
            String c = eName.getText().toString();
            if(!t.isEmpty() && p.matches("\\d+")){
                Ticket ticket = new Ticket(t,p,a,b,c);
                SQLiteHelper db = new SQLiteHelper(this);
                db.addTicket(ticket);
                finish();
            }
        }


//        if(view == btClose){
//            finish();
//        }
//        if(view == btDecrease){
//            if(count >1) {
//                count--;
//                tvQuantity.setText(Integer.toString(count));
//                tvTotal.setText(Integer.toString(count * food.getPrice()));
//            }
//        }
//        if(view == btIncrease){
//            count ++;
//            tvQuantity.setText(Integer.toString(count));
//            tvTotal.setText(Integer.toString(count * food.getPrice()));
//        }
//
//        if(view == btAdd){
//            db = new SQLiteHelper(this);
//            db.addItemToCart(food, count);
//            //finish();
//        }
    }
}