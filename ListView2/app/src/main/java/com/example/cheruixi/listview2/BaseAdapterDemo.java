package com.example.cheruixi.listview2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BaseAdapterDemo extends AppCompatActivity {

    private ListView myListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter_demo);
        myListView = findViewById(R.id.baseDemo);

        String[] data = {"jesse", "steven"};

        MyAdapter myAdapter = new MyAdapter(data, BaseAdapterDemo.this);

        myListView.setAdapter(myAdapter);
    }

    class MyAdapter extends BaseAdapter {

        private String[] data;
        private Context context;
        public  MyAdapter(String[] data, Context context){
            super();
            this.data = data;
            this.context = context;
        }
        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public Object getItem(int position) {
            return data[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
//            TextView tv = new TextView(context);
//            tv.setText(data[position]);
//            return tv;

            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View layoutView = layoutInflater.inflate(R.layout.base, null);
            final TextView textView = layoutView.findViewById(R.id.title);
            textView.setText(data[position]);
            Button button = layoutView.findViewById(R.id.confirm);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView.setText("click you");
                }
            });
            return layoutView;
        }
    }
}
