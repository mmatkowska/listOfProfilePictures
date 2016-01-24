package com.gosiamatkowska.listofprofilepictures.fragment;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gosiamatkowska.listofprofilepictures.R;
import com.gosiamatkowska.listofprofilepictures.adapter.MyAdapter;
import com.gosiamatkowska.listofprofilepictures.api.UsersService;
import com.gosiamatkowska.listofprofilepictures.model.User;
import com.gosiamatkowska.listofprofilepictures.model.UserWrapper;

import java.io.IOException;
import java.util.List;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.Call;

public class ListFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private UsersService mService;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        mRecyclerView = ((RecyclerView) view.findViewById(R.id.recycler_view));
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initRecyclerView();
        createAPI();
        UserLoader userLoader = new UserLoader();
        userLoader.execute();
    }

    private void initRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    private void createAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.stackexchange.com/2.2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mService = retrofit.create(UsersService.class);
    }

    private class UserLoader extends AsyncTask<Void, Void, List<User>> {

        @Override
        protected List<User> doInBackground(Void... params) {
            Call<UserWrapper> listCall = mService.getUserWrapper();
            List<User> users = null;
            try {
                UserWrapper userWrapper = listCall.execute().body();
                users = userWrapper.getUsers();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return users;
        }

        @Override
        protected void onPostExecute(List<User> users) {
            super.onPostExecute(users);
            MyAdapter adapter = new MyAdapter(getActivity(), users);
            mRecyclerView.setAdapter(adapter);
        }
    }
}