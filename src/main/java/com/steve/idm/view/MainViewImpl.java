package com.steve.idm.view;

import com.steve.idm.presenter.MainPresenter;

import javax.swing.*;

public class MainViewImpl implements MainView {
    private MainPresenter presenter;
    private JFrame frame;

    public void setPresenter(MainPresenter presenter) {
        this.presenter = presenter;
    }

    public void createView() {
        frame = new JFrame();
        frame.setTitle("IDM");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        populateMenubar(frame);
    }

    private void populateMenubar(JFrame frame) {
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        createTaskMenu(menuBar);
        createFilesMenu(menuBar);
    }

    private void createFilesMenu(JMenuBar menuBar) {
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
    }

    private void createTaskMenu(JMenuBar menuBar) {
        JMenu tasksMenu = new JMenu("Tasks");
        menuBar.add(tasksMenu);

        JMenuItem addNewDownloadItem = new JMenuItem("Add New Download");
        tasksMenu.add(addNewDownloadItem);

        JMenuItem addBatchDownloadItem = new JMenuItem("Add Batch Download");
        tasksMenu.add(addBatchDownloadItem);

        JMenuItem addBatchDownloadFromClipboardItem = new JMenuItem("Add Batch Download from Clipboard");
        tasksMenu.add(addBatchDownloadFromClipboardItem);

        tasksMenu.addSeparator();
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        tasksMenu.add(exitMenuItem);
        exitMenuItem.addActionListener(e -> presenter.onExitActionPerformed());
    }

    @Override
    public void quitApp() {
        frame.dispose();
    }
}
