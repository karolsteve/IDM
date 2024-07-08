package com.steve.idm.presenter;

import com.steve.idm.view.MainView;

/**
 * Created By Steve Tchatchouang
 * Date : 07/07/2024
 */
public class MainPresenterImpl implements MainPresenter {
    private final MainView view;

    public MainPresenterImpl(MainView view) {
        this.view = view;
    }

    @Override
    public void onExitActionPerformed() {
        view.quitApp();
    }
}
