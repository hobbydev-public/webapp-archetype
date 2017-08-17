package groupId.artifactId.business.services;

import groupId.artifactId.domain.core.LogEntry;

import java.util.List;

public interface LoggingService {
	
	List<LogEntry> listLogs();
	LogEntry addLog(LogEntry logEntry);
}
