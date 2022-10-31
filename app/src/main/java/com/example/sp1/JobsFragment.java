package com.example.sp1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sp1.Adapters.JobsAdapter;
import com.example.sp1.Models.Jobs;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link JobsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JobsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ArrayList<Jobs>jobsModel = new ArrayList<>();

    public JobsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JobsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static JobsFragment newInstance(String param1, String param2) {
        JobsFragment fragment = new JobsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_jobs, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.jobs_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        setUpJobsList();
        JobsAdapter jobsAdapter = new JobsAdapter(this.getContext(),jobsModel);
        recyclerView.setAdapter(jobsAdapter);
        return view;
//        return inflater.inflate(R.layout.fragment_jobs, container, false);
    }
    private void setUpJobsList(){
        String [] jobCounties = getResources().getStringArray(R.array.county);
        String [] jobPersons = getResources().getStringArray(R.array.person_name);
        String [] jobLocations = getResources().getStringArray(R.array.location);
        String [] jobPrices = getResources().getStringArray(R.array.price);
        for(int i=0;i< jobCounties.length;i++){
            jobsModel.add(new Jobs( jobCounties[i],
                    jobPersons[i],
                    jobLocations[i],
                    jobPrices[i],
                    R.drawable.nairobi));
        }

    }

}