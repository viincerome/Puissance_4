package fr.enssat.poo.vrome.utilities;

/**
 * DefaultLogger that use the standart output (System.out) to display
 * information.
 */
public class SystemOutLogger extends Logger {

	private boolean error = true;
	private boolean info = true;
	private boolean warn = true;
	private boolean debug = true;

	public SystemOutLogger(Class<?> clazz) {
		super(clazz);
	}

	@Override
	public void debug(final CharSequence content) {
		if ( isDebugEnabled() ) {
			System.out.println("[DEBUG - " + getClazz().getName() + "] " + content); // NOSONAR: System.out and System.err should not be used as loggers
		}
	}

	@Override
	public void error(final CharSequence content) {
		if ( isErrorEnabled() ) {
			System.out.println("[ERROR - " + getClazz().getName() + "] " + content); // NOSONAR: System.out and System.err should not be used as loggers
		}
	}

	@Override
	public void info(final CharSequence content) {
		if ( isInfoEnabled() ) {
			System.out.println("[INFO - " + getClazz().getName() + "] " + content); // NOSONAR: System.out and System.err should not be used as loggers
		}
	}

	@Override
	public boolean isDebugEnabled() {
		return this.debug;
	}

	@Override
	public boolean isErrorEnabled() {
		return this.error;
	}

	@Override
	public boolean isInfoEnabled() {
		return this.info;
	}

	@Override
	public boolean isWarnEnabled() {
		return this.warn;
	}

	@Override
	public void setDebugEnable(final boolean enable) {
		this.debug = enable;
	}

	@Override
	public void setErrorEnable(final boolean enable) {
		this.error = enable;
	}

	@Override
	public void setInfoEnable(final boolean enable) {
		this.info = enable;
	}

	@Override
	public void setWarnEnable(final boolean enable) {
		this.warn = enable;
	}

	@Override
	public void warn(final CharSequence content) {
		if ( isWarnEnabled() ) {
			System.out.println("[WARN - " + getClazz().getName() + "] " + content); // NOSONAR: System.out and System.err should not be used as loggers
		}
	}
}
