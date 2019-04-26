package com.rz.iot.think.service;

import javax.servlet.http.HttpServletResponse;

public interface LogsManagerService {
    /**
     *
     * @param name
     * @param response
     */
    void ExportExcel(String name, HttpServletResponse response);

}