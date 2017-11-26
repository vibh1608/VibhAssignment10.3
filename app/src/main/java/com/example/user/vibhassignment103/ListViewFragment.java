package com.example.user.vibhassignment103;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Ashutosh on 24-06-2017.
 */

public class ListViewFragment extends ListFragment {

    // Array of strings storing country names
    String[] titles = new String[] {
            "You Tube",
            "Blogger"
    };

    // Array of integers points to images stored in /res/drawable/
    int[] imageID = new int[]{
            R.drawable.you_tube,
            R.drawable.blogger
    };

    // Array of strings to store currencies
    String[] details = new String[]{
            "You Tube Description",
            "Blogger Description",
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Each row in the list stores country name, currency and flag
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<2;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("title",titles[i]);
            hm.put("detail",details[i]);
            hm.put("icon", Integer.toString(imageID[i]) );
            aList.add(hm);
        }

        // Keys used in Hashmap
        String[] from = { "icon","title","detail" };

        // Ids of views in listview_layout
        int[] to = { R.id.icon,R.id.title,R.id.detail};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.fragment_list_view, from, to);

        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Toast.makeText(getActivity().getApplicationContext(),titles[position]+" is Clicked",Toast.LENGTH_SHORT).show();

    }
}
