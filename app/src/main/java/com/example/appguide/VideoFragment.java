package com.example.appguide;


import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VideoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VideoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private static final String TAG = "VideoFragment";

    private static final String ARG_VIDEO_INDEX = "video_index";


    // TODO: Rename and change types of parameters
    private int index;

    int[] res = {R.raw.welcome01,R.raw.welcome02};

    private VideoView video_view ;
    public VideoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment VideoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VideoFragment newInstance(int index) {
        VideoFragment fragment = new VideoFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_VIDEO_INDEX, index);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG,"onCreate");
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_VIDEO_INDEX);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.e(TAG,"onCreateView");
        return inflater.inflate(R.layout.fragment_video, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e(TAG,"onViewCreated");
        video_view = view.findViewById(R.id.video_view);
       // onLoad();
    }


    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG,"onResume");
        onLoad();
    }

    private void onLoad()
    {
        Uri uri = (Uri.parse("android.resource://" + getActivity().getPackageName() + "/" +res[index]));
        video_view.setVideoURI(uri);
        video_view.start();
    }
}
