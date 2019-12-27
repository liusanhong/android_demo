package com.example.lq_core.delegates;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * file_name:BaseDelegate
 * date:2019-12-26 08:55
 * author:LQ
 * describe:TODO
 */
public abstract class BaseDelegate extends SwipeBackFragment {
    public abstract Object setLayout();
    public abstract void onBindView(@Nullable Bundle savedInstanceState,View rootView);

    @SuppressWarnings("SpellCheckingInspection")
    private Unbinder mUnbinder = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = null;
        if(setLayout() instanceof Integer){
            rootView = inflater.inflate((Integer) setLayout(),container,false);
        }else if(setLayout() instanceof View){
            rootView = (View) setLayout();
        }

        if(rootView != null){
            mUnbinder = ButterKnife.bind(this,rootView);
            onBindView(savedInstanceState,rootView);
        }

        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(mUnbinder!=null){
            mUnbinder.unbind();
        }
    }
}
