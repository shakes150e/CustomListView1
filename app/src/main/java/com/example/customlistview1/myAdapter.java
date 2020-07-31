package com.example.customlistview1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class myAdapter extends ArrayAdapter<String> {

    String [] names;
    int [] flags;
    Context mContext;

    public myAdapter(@NonNull Context context, String[] countryNames, int[] countryFlags) {
        super(context, R.layout.listview_item);
        this.names = countryNames;
        this.flags = countryFlags;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        viewHolder mViewHolder = new viewHolder();
        if(convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert mInflater != null;
            convertView = mInflater.inflate(R.layout.listview_item, parent, false);
            mViewHolder.mFlag = (ImageView) convertView.findViewById(R.id.imageView2);
            mViewHolder. mName = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(mViewHolder);

        }else {
            mViewHolder = (viewHolder) convertView.getTag();
        }

            mViewHolder.mFlag.setImageResource(flags[position]);
            mViewHolder.mName.setText(names[position]);

        return convertView;
    }

    static class viewHolder{
        ImageView mFlag;
        TextView mName;
    }
}
