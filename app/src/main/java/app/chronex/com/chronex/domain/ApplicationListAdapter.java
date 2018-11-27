package app.chronex.com.chronex.domain;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextSwitcher;
import android.widget.TextView;

import java.util.List;

import app.chronex.com.chronex.R;

/**
 * Created by paradigm on 11/26/2018.
 */

public class ApplicationListAdapter extends RecyclerView.Adapter<ApplicationListAdapter.ItemHolder> {

    private Context mContext;
    private List<Application> appList;


    public ApplicationListAdapter(Context mContext, List<Application> appList) {
        this.mContext = mContext;
        this.appList = appList;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);

        return new ItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        Application app = appList.get(position);
//        To Do Shto foton edhe Checkboxin
        holder.applicationName.setText(app.getName());
        holder.applicationName.setSelected(app.isSelected());
    }

    @Override
    public int getItemCount() {
        return appList.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        protected SwitchCompat applicationName;
        protected ImageView appThumbnail;

        public ItemHolder(View view) {
            super(view);
            applicationName = view.findViewById(R.id.app_name);
            appThumbnail = view.findViewById(R.id.appThumbnail);
        }
    }
}
