package app.chronex.com.chronex.domain;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import app.chronex.com.chronex.R;

/**
 * Created by paradigm on 11/26/2018.
 */

public class ApplicationsAdapter extends RecyclerView.Adapter<ApplicationsAdapter.MyViewHolder> {

    private Context mContext;
    private List<Application> appList;


    public ApplicationsAdapter(Context mContext, List<Application> appList) {
        this.mContext = mContext;
        this.appList = appList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);

        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_apps, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Application app = appList.get(position);
        holder.title.setText(app.getName());
        holder.count.setText(37 + " songs");

        // loading album cover using Glide library
        //Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);

    }

    @Override
    public int getItemCount() {
        return appList.size();
    }


}
