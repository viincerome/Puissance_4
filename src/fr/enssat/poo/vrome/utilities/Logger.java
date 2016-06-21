package fr.enssat.poo.vrome.utilities;

public abstract class Logger {

    private final Class<?> clazz;

    public Logger(Class<?> clazz) {
        this.clazz = clazz;
    }

    public abstract void debug(CharSequence content);

    public abstract void error(CharSequence content);

    public Class<?> getClazz() {
        return this.clazz;
    }

    public abstract void info(CharSequence content);

    public abstract boolean isDebugEnabled();

    public abstract boolean isErrorEnabled();

    public abstract boolean isInfoEnabled();

    public abstract boolean isWarnEnabled();

    // Remove ?
    public abstract void setDebugEnable(boolean enable);

    // Remove ?
    public abstract void setErrorEnable(boolean enable);

    // Remove ?
    public abstract void setInfoEnable(boolean enable);

    // Remove ?
    public abstract void setWarnEnable(boolean enable);

    public abstract void warn(CharSequence content);
}
