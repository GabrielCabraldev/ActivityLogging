package com.MessageProcessor;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class InactivityMonitor {
    private static final long INACTIVITY_THRESHOLD = +1000; // 15 minutos
    private long lastActivityTime;
    private Timer timer;
    private Logger logger;

    public InactivityMonitor(Logger logger) {
        this.logger = logger;
        this.lastActivityTime = System.currentTimeMillis();
        startTimer();
    }

    // Atualiza o tempo de atividade
    public void updateActivity() {
        lastActivityTime = System.currentTimeMillis();
    }

    // Inicia o Timer para verificar a inatividade
    private void startTimer() {
        timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                long currentTime = System.currentTimeMillis();
                if (currentTime - lastActivityTime > INACTIVITY_THRESHOLD) {
                    logger.logInactivity(LocalDateTime.now());
                    lastActivityTime = currentTime;
                }
            }
        }, 0, 1000); // tempo de verificacao
    }
}
