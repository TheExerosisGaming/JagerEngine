package me.exerosis.jager.engine.core;

import me.exerosis.jager.engine.core.component.Component;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Exerosis.
 */
public class Game extends Component {
    private final ReentrantLock lock = new ReentrantLock();
    private boolean enabled = false;

    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                Game game = new Game() {
                    @Override
                    protected void onEnable() {
                        System.out.println("Enabled Game 1");
                    }

                    @Override
                    protected void onDisable() {
                        System.out.println("Disabled Game 1");
                    }
                };
                game.enable();
                new Thread(){
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        game.disable();
                    }
                }.run();




                Game game2 = new Game() {
                    @Override
                    protected void onEnable() {
                        System.out.println("Enabled Game 2");
                    }

                    @Override
                    protected void onDisable() {
                        System.out.println("Disabled Game 2");
                    }
                };
                game2.enable();
                new Thread(){
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        game2.disable();
                    }
                }.run();
            }
        }.run();
    }


    public Game() {

    }

    @Override
    public void enable() {
        super.enable();
        lock.lock();
    }

    @Override
    public void disable() {
        super.disable();
        if (lock.isHeldByCurrentThread())
            lock.unlock();
    }
}
