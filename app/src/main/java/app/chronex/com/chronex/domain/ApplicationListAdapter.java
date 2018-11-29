package app.chronex.com.chronex.domain;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import app.chronex.com.chronex.R;
import app.chronex.com.chronex.persistence.AppDatabase;

/**
 * Created by paradigm on 11/26/2018.
 */

public class ApplicationListAdapter extends RecyclerView.Adapter<ApplicationListAdapter.ItemHolder> {

    private Context mContext;
    private List<ApplicationItem> appList;


    public ApplicationListAdapter(Context mContext, List<ApplicationItem> appList) {
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
    public void onBindViewHolder(final ItemHolder holder, int position) {
        //TODO reafactor database queries
        final ApplicationItem app = appList.get(position);
        final AppDatabase database = AppDatabase.getAppDatabase(this.mContext);
        holder.appSwitch.setText(app.getName());
        holder.appSwitch.setChecked(app.isSelected());
        holder.appSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SwitchCompat s = (SwitchCompat) v;
                if(s.isChecked())
                    database.applicationNameDao().insert(new ApplicationName(s.getText().toString()));
                else
                    database.applicationNameDao().delete(new ApplicationName(s.getText().toString()));
                app.setSelected(s.isChecked());
            }
        });
        holder.appThumbnail.setImageDrawable(app.getIcon());
    }

    @Override
    public int getItemCount() {
        return appList.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        protected SwitchCompat appSwitch;
        protected ImageView appThumbnail;

        public ItemHolder(View view) {
            super(view);
            appSwitch = view.findViewById(R.id.app_switch);
            appThumbnail = view.findViewById(R.id.appThumbnail);
        }
    }
}
