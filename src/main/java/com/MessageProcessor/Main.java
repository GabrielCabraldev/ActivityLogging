package com.MessageProcessor;


import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;

public class Main {
    public static void main(String[] args) {
        //caminho log
        Logger logger = new Logger("C:\\Users\\gabri\\OneDrive\\Documentos\\workspace\\inactivity_log.txt");

        // inicia monitor de inatividade
        InactivityMonitor monitor = new InactivityMonitor(logger);

        // Listener de Atividade
        ActivityListener listener = new ActivityListener(monitor);

        try {
            // Registrar os hooks globais
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            System.err.println("Erro ao registrar o Native Hook: " + e.getMessage());
            return;
        }

        // Adicionar listeners de mouse e teclado
        GlobalScreen.addNativeKeyListener(listener);
        GlobalScreen.addNativeMouseListener(listener);

        System.out.println("Monitor de inatividade iniciado. Logs serão registrados após 15 minutos de inatividade.");
    }
}

