wmic path Win32_PerfFormattedData_PerfProc_Process get Name,PercentProcessorTime | FIND "chrome"
pause