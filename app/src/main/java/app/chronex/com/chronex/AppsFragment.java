package app.chronex.com.chronex;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import app.chronex.com.chronex.application.ApplicationLoader;
import app.chronex.com.chronex.domain.ApplicationItem;
import app.chronex.com.chronex.domain.ApplicationListAdapter;

/**
 * Created by paradigm on 11/26/2018.
 */

public class AppsFragment extends Fragment {

    private RecyclerView recyclerView;
    private ApplicationListAdapter adapter;



    private List<ApplicationItem> applicationList = new ArrayList<ApplicationItem>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_apps, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);


        loadApplications(view.getContext());
        adapter = new ApplicationListAdapter(view.getContext(), applicationList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        return view;
    }

     public void loadApplications(final Context context){
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                ApplicationLoader loader = ApplicationLoader.load(context);
                applicationList.addAll(loader.get());
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                adapter.notifyDataSetChanged();
            }
        }.execute();
    }
}

