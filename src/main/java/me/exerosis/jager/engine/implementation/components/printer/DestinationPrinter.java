package me.exerosis.jager.engine.implementation.components.printer;

/**
 * Created by Exerosis.
 */
public abstract class DestinationPrinter {
    private PrintLevel currentPrintLevel = PrintLevel.NORMAL;
    private PrintLevel defaultPrintLevel = PrintLevel.NORMAL;

    protected abstract void _print(Object message);

    public void print(Object message){
        print(message, defaultPrintLevel);
    }

    public void print(Object message, PrintLevel printLevel){
        if(currentPrintLevel.ordinal() <= printLevel.ordinal())
            _print(message);
    }

    public PrintLevel getDefaultPrintLevel() {
        return defaultPrintLevel;
    }

    public void setDefaultPrintLevel(PrintLevel defaultPrintLevel) {
        this.defaultPrintLevel = defaultPrintLevel;
    }

    public PrintLevel getCurrentLevel() {
        return currentPrintLevel;
    }

    public void setCurrentLevel(PrintLevel currentPrintLevel) {
        this.currentPrintLevel = currentPrintLevel;
    }
}
