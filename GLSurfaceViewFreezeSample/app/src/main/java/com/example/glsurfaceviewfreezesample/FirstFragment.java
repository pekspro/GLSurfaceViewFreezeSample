package com.example.glsurfaceviewfreezesample;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import com.example.glsurfaceviewfreezesample.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.OpenGlGameGraphics.setRenderer(new OpenGLRenderer());

        binding.buttonFirstWithAnimation.setOnClickListener(view1 -> {
            FragmentManager manager = getParentFragmentManager();

            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.FragmentMain, new SecondFragment());
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            ft.addToBackStack(null);

            ft.commit();
        });

        binding.buttonFirstNoAnimation.setOnClickListener(view1 -> {
            FragmentManager manager = getParentFragmentManager();

            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.FragmentMain, new SecondFragment());
            ft.addToBackStack(null);

            ft.commit();
        });
    }

    @Override
    public void onResume()
    {
        super.onResume();

        binding.OpenGlGameGraphics.onResume();
    }

    @Override
    public void onPause()
    {
        super.onPause();

        binding.OpenGlGameGraphics.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}