package com.example.prachi.listview_custom_row_xml;

import android.content.Context;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> name;
    ArrayList<Integer> image;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      name=new ArrayList<String>();
      image=new ArrayList<Integer>();
     lv=(ListView)findViewById(R.id.listView);
      name.add("A");
        name.add("B");
        name.add("C");

        image.add(R.mipmap.ic_launcher);
        image.add(R.mipmap.ic_launcher);
        image.add(R.mipmap.ic_launcher);

        mybase obj=new mybase();
        lv.setAdapter(obj);
    }

    class mybase extends BaseAdapter
    {
        LayoutInflater layoutInflater;
        mybase()
        {
            layoutInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return name.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        class ViewHolder
        {
           ImageView iv;
            TextView tv;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder v=null;
            if (convertView == null) {
                v=new ViewHolder();
               convertView= layoutInflater.inflate(R.layout.rowfile,null);
               v.iv=(ImageView)convertView.findViewById(R.id.m1);
                v.tv=(TextView)convertView.findViewById(R.id.t1);
                convertView.setTag(v);
            }
            else
            {
             v=(ViewHolder) convertView.getTag();
            }

            v.tv.setText(name.get(position));
            v.iv.setImageResource(image.get(position));

            return convertView;
        }
    }
}
