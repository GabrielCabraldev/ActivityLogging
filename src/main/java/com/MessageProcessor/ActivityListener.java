package com.MessageProcessor;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseListener;

public class ActivityListener implements NativeKeyListener, NativeMouseListener {
    private InactivityMonitor inactivityMonitor;

    public ActivityListener(InactivityMonitor inactivityMonitor) {
        this.inactivityMonitor = inactivityMonitor;
    }

    // Eventos do teclado
    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        inactivityMonitor.updateActivity();
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {}

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {}

    // Eventos do mouse
    @Override
    public void nativeMouseClicked(NativeMouseEvent e) {
        inactivityMonitor.updateActivity();
    }

    @Override
    public void nativeMousePressed(NativeMouseEvent e) {}

    @Override
    public void nativeMouseReleased(NativeMouseEvent e) {}
}