package com.rz.iot.think.model.screen;

/**
 * Author by xuxiake, Date on 2019/3/29.
 * PS: Not easy to write code, please indicate.
 * Description：
 */
public class DownloadProgressModel {

    private String commandId;

    private String taskItemId;

    private Integer progress;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    public String getTaskItemId() {
        return taskItemId;
    }

    public void setTaskItemId(String taskItemId) {
        this.taskItemId = taskItemId;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    @Override
    public String toString() {
        return "DownloadProgressModel{" +
                "commandId='" + commandId + '\'' +
                ", taskItemId='" + taskItemId + '\'' +
                ", progress=" + progress +
                '}';
    }
}
