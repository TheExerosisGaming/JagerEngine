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
                        new Thread(){
                          @Override
                          public void run() {
                              try {
                                  Thread.sleep(5000);
                              } catch (InterruptedException e) {
                                  e.printStackTrace();
                              }
                              disable();
                          }
                        }.run();
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
                        new Thread(){
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(5000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                disable();
                            }
                        }.run();
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
    protected void onEnable() {
        super.onEnable();
        lock.lock();
    }

    @Override
    protected void onDisable() {
        super.onDisable();
        lock.unlock();
    }
}
