package me.exerosis.jager.engine.core;

import me.exerosis.jager.engine.core.component.Component;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Exerosis.
 */
public class Game extends Component {
    private final Lock lock = new ReentrantLock();
    private boolean enabled = false;

    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                new Game(){
                    @Override
                    protected void onEnable() {
                        System.out.println("Enabled Game 1");
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        disable();
                    }

                    @Override
                    protected void onDisable() {
                        System.out.println("Disabled Game 1");
                    }
                }.enable();

                new Game(){
                    @Override
                    protected void onEnable() {
                        System.out.println("Enabled Game 2");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        disable();
                    }

                    @Override
                    protected void onDisable() {
                        System.out.println("Disabled Game 2");
                    }
                }.enable();
            }
        }.run();
    }


    public Game() {

    }

    @Override
    public synchronized void enable() {
        if (!isEnabled())
            return;
        onDisable();
//        lock.lock();
        enabled = false;
    }

    @Override
    public synchronized void disable() {
        if (!isEnabled())
            return;
        onDisable();
//        lock.unlock();
        enabled = false;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
