package com.example.glsurfaceviewfreezesample;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.fragment.NavHostFragment;

import com.example.glsurfaceviewfreezesample.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.OpenGlGameGraphics.setRenderer(new OpenGLRenderer());

        binding.buttonSecond.setOnClickListener(view1 -> {
            FragmentManager manager = getParentFragmentManager();
            manager.popBackStack();
        });
    }

    @Override
    public void onResume() 
    {
        super.onResume();

        if (binding.OpenGlContainer.getChildCount() == 0) {
            new Handler().postDelayed(() -> {
                binding.OpenGlContainer.addView(binding.OpenGlGameGraphics);
            }, 0);
        }

        binding.OpenGlGameGraphics.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();

        binding.OpenGlGameGraphics.onPause();
        binding.OpenGlContainer.removeView(binding.OpenGlGameGraphics);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}