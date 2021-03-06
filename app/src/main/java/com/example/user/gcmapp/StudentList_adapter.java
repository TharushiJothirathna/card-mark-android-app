package com.example.user.gcmapp;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class StudentList_adapter extends BaseAdapter {

    private ArrayList<DatabaseColumn> mDatabaseColumnList;
    private Context mContext;
    private MainActivity mainActivity;

    public StudentList_adapter(Context context, ArrayList<DatabaseColumn> databaseColumnList,MainActivity mainActivity) {

        this.mDatabaseColumnList=databaseColumnList;
        this.mContext=context;
        this.mainActivity=mainActivity;
    }
    @Override
    public int getCount() {
        return mDatabaseColumnList.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatabaseColumnList.size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View v= View.inflate(mContext,R.layout.list_student,null);

        TextView txtPhoneNo=(TextView)v.findViewById(R.id.student_phone_no_list_textView);
        TextView txtSname=(TextView)v.findViewById(R.id.student_name_list_textView);
        ImageView imgSlistitem=(ImageView)v.findViewById(R.id.list_student_image);

        imgSlistitem.setImageResource(R.drawable.ic_more_vert_black);


        imgSlistitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                PopupMenu popup = new PopupMenu(mContext, v);
                popup.getMenuInflater().inflate(R.menu.student_option_menu,
                        popup.getMenu());
                popup.show();

               popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                   @Override
                   public boolean onMenuItemClick(MenuItem menuItem) {

                       switch (menuItem.getItemId()) {
                           case R.id.update_option_student:

                               mainActivity.ShowFragment(3,null,mDatabaseColumnList.get(position));
                               break;
                           case R.id.delete_option_student:

                               mainActivity.ShowFragment(5,null,mDatabaseColumnList.get(position));
                               break;

                           case R.id.CheckMarks_option_student:

                               mainActivity.ShowFragment(10,null,mDatabaseColumnList.get(position));

                               break;
                           case R.id.Check_Attendence_option_student:

                               mainActivity.ShowFragment(16,null,mDatabaseColumnList.get(position));

                               break;

                           default:
                               break;
                       }



                       return false;
                   }
               });


            }
        });

        txtPhoneNo.setText(mDatabaseColumnList.get(position).getStudent_phone_no());
        txtSname.setText(mDatabaseColumnList.get(position).getStudent_name());

        v.setTag(mDatabaseColumnList.get(position).getStudent_id());
        return v;

    }
}
