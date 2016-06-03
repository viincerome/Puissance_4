package fr.enssat.poo.vrome.utilities;

public abstract class Logger {

    private final Class<?> clazz;

    public Logger(Class<?> clazz) {
        this.clazz = clazz;
    }

    public abstract boolean isErrorEnabled();

    // Remove ?
    public abstract void setErrorEnable(boolean enable);

    public abstract void error(CharSequence content);

    public abstract boolean isWarnEnabled();

    public abstract void warn(CharSequence content);

    // Remove ?
    public abstract void setWarnEnable(boolean enable);

    public abstract boolean isInfoEnabled();

    public abstract void info(CharSequence content);

    // Remove ?
    public abstract void setInfoEnable(boolean enable);

    public abstract boolean isDebugEnabled();

    public abstract void debug(CharSequence content);

    // Remove ?
    public abstract void setDebugEnable(boolean enable);

    public Class<?> getClazz() {
        return clazz;
    }
}