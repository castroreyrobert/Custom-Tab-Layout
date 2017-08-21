package com.example.customtab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by castroreyrobert on 8/21/17.
 */

    public class FragmentTab extends Fragment {
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            TextView txt = new TextView(getActivity());
            txt.setText(getArguments().getString("text"));
            return  txt;
        }
}
