package app.chronex.com.chronex;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import app.chronex.com.chronex.domain.Application;
import app.chronex.com.chronex.domain.ApplicationListAdapter;

/**
 * Created by paradigm on 11/26/2018.
 */

public class AppsFragment extends Fragment {

    private RecyclerView recyclerView;
    private ApplicationListAdapter adapter;
    private List<Application> applicationList = new ArrayList<Application>(){
        {
            add(new Application("asasaassa",false));
            add(new Application("adadasdas",false));
            add(new Application("qwewqe",true));
            add(new Application("12312321312",false));
            add(new Application("a",false));
            add(new Application("b",true));
            add(new Application("a",false));
            add(new Application("a",false));
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_apps, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        adapter = new ApplicationListAdapter(view.getContext(), applicationList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        return view;
    }
}

