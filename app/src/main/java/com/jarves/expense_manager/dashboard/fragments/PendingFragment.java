package com.jarves.expense_manager.dashboard.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jarves.expense_manager.R;
import com.jarves.expense_manager.dashboard.CreateTaskActivity;
import com.jarves.expense_manager.dashboard.adapters.TaskAdapter;
import com.jarves.expense_manager.class_components.Task;
import com.jarves.expense_manager.database.Database;

import java.util.ArrayList;

public class PendingFragment extends Fragment {
    FloatingActionButton createButton;
    ListView listView;
    ArrayList<Task> tasks;

    public PendingFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

            Database database = new Database(getContext());
            tasks = database.getTasksPending();

            View view = inflater.inflate(R.layout.fragment_pending, container, false);
            listView = view.findViewById(R.id.list_view);
            createButton = view.findViewById(R.id.create_button);

            TaskAdapter taskAdapter = new TaskAdapter(getActivity(), tasks);
            listView.setAdapter(taskAdapter);

            createButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //create button click event
                    Intent intent = new Intent(getContext(), CreateTaskActivity.class);
                    startActivity(intent);
                }
            });
            return view;
        }
    }