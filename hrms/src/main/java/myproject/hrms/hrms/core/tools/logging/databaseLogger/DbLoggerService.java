package myproject.hrms.hrms.core.tools.logging.databaseLogger;

import myproject.hrms.hrms.core.utilities.results.Result;

public interface DbLoggerService {
	Result addLogger(char[] data);
	Result updateLogger(char[] data);
	Result deleteLogger(char[] data);
}
